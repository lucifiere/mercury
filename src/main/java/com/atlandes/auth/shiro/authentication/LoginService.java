package com.atlandes.auth.shiro.authentication;

import com.atlandes.auth.bo.Login;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by XD.Wang on 2017/6/15.
 * 登录
 */
@Service
public class LoginService {

    public void login(Login user) {
        // 身份验证
        UsernamePasswordToken token = new UsernamePasswordToken(user.getNickname(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }

    public void loginOut() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
    }

}
