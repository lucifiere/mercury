package com.atlandes.auth.shiro.realm;

import com.atlandes.auth.enums.LockedStatus;
import com.atlandes.auth.po.User;
import com.atlandes.auth.service.PermissionService;
import com.atlandes.auth.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by XD.Wang on 2017/6/15.
 * DB Realm
 */
public class MercuryRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private PermissionService permissionService;

    @Override
    public String getName() {
        return "mercuryRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取凭证
        String nickname = (String) authenticationToken.getPrincipal();
        // 检查凭证
        User userInfo = userService.findUserByNickname(nickname);
        if (userInfo == null) {
            throw new UnknownAccountException();
        }
        if (userInfo.getIsLocked() == LockedStatus.LOCKED.getCode()) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(nickname, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getPasswordCredit()), this.getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roleIds = userService.selectRoleByNickname(username);
        authorizationInfo.setRoles(roleIds);
        StringBuilder roleIdSb = new StringBuilder();
        for (String id : roleIds) {
            roleIdSb.append(id);
        }
        authorizationInfo.setStringPermissions(permissionService.findPermissionUrlByRoleIds(roleIdSb.toString()));
        return authorizationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}


