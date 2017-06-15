package com.atlandes.auth.shiro.realm;

import com.atlandes.auth.po.User;
import com.atlandes.auth.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by XD.Wang on 2017/6/15.
 * DB Realm
 */
@Component(value = "nickPasswordRealm")
public class MercuryRealm implements Realm {

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
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
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

}
