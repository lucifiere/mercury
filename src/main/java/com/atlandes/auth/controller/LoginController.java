package com.atlandes.auth.controller;

import com.atlandes.auth.bo.Login;
import com.atlandes.auth.shiro.authentication.LoginService;
import com.atlandes.common.pojo.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by XD.Wang on 2017/6/15.
 * 用户登录
 */
@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("admin/login")
    public String toLoginPage() {
        return "auth/login";
    }

    @RequestMapping("auth/login")
    @ResponseBody
    public Result login(@RequestBody Login user) {
        try {
            loginService.login(user);
            return Result.suc("登录成功！");
        } catch (UnknownAccountException e) {
            return Result.fail("登录失败，该用户不存在！");
        } catch (IncorrectCredentialsException e) {
            return Result.fail("登录失败，密码错误！");
        }
    }

}
