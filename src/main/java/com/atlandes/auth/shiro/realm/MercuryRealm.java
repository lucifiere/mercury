package com.atlandes.auth.shiro.realm;

import com.atlandes.auth.po.User;
import com.atlandes.auth.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * Created by XD.Wang on 2017/6/15.
 * DB Realm
 */
@Component(value = "nickPasswordRealm")
public class MercuryRealm extends AuthorizingRealm implements Realm, InitializingBean {

    @Resource
    private UserService userService;

    @Override
    public String getName() {
        return "nickPasswordRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取凭证
        String nickname = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        // 检查凭证
        User userInfo = userService.findUserByNickname(nickname);
        if (!nickname.equals(userInfo.getNickname())) {
            throw new UnknownAccountException();
        }
        if (!password.equals(userInfo.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(nickname, userInfo.getPassword(), this.getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(userService);
    }
}
