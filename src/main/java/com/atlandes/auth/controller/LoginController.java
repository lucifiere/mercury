package com.atlandes.auth.controller;

import com.alibaba.fastjson.JSON;
import com.atlandes.admin.service.MenuService;
import com.atlandes.admin.service.ModuleService;
import com.atlandes.auth.bo.Login;
import com.atlandes.auth.shiro.authentication.LoginService;
import com.atlandes.common.pojo.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by XD.Wang on 2017/6/15.
 * 用户登录
 */
@Controller
public class LoginController {

    @Resource
    private
    MenuService menuService;

    @Resource
    private
    ModuleService moduleService;

    @Resource
    private LoginService loginService;

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("admin/login")
    public String toLoginPage() {
        return "auth/login";
    }

    @RequestMapping("auth/login")
    public String login(Login user, Model model) {
        String tip = "登录成功!";
        try {
            loginService.login(user);
            log.debug(tip + JSON.toJSONString(user));
            return "redirect:/admin/index";
        } catch (UnknownAccountException e) {
            tip = "登录失败，该用户不存在!";
            log.debug(tip + JSON.toJSONString(user));
            model.addAttribute("result", Result.suc(tip));
            return "auth/login";
        } catch (IncorrectCredentialsException e) {
            tip = "登录失败，密码错误!";
            log.debug(tip + JSON.toJSONString(user));
            model.addAttribute("result", Result.suc(tip));
            return "auth/login";
        } catch (LockedAccountException e) {
            tip = "登录失败，该用户已被封杀!";
            log.debug(tip + JSON.toJSONString(user));
            model.addAttribute("result", Result.suc(tip));
            return "auth/login";
        }
        catch (AuthenticationException e) {
            tip = "内部错误，请联系lucifiere@126.com！";
            log.debug(tip + JSON.toJSONString(user));
            model.addAttribute("result", Result.suc(tip));
            return "auth/login";
        }
    }

    @RequestMapping("auth/loginOut")
    public String loginOut() {
        loginService.loginOut();
        return "auth/login";
    }

}
