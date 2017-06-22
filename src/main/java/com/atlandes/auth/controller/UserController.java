package com.atlandes.auth.controller;

import com.atlandes.auth.service.UserService;
import com.atlandes.auth.vo.UserQuery;
import com.atlandes.auth.vo.UserVO;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.pojo.Result;
import com.atlandes.common.service.PaginationQueryService;
import com.atlandes.common.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by XD.Wang on 2017/6/2.
 * 用户信息
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private
    UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("list")
    public ModelAndView getUserList(UserQuery query) {
        ModelAndView mv = new ModelAndView("/auth/user");
        Pagination<UserVO> paging = PageUtil.getPagingList(new PaginationQueryService<UserVO>() {
            @Override
            public Pagination<UserVO> getList4Page(Pagination var1) {
                return userService.getUserList4Page(var1);
            }
        }, query);
        mv.addObject("userList", paging.getResult());
        mv.addObject("pageTotalCount", paging.getPageTotalCount());
        return mv;
    }

    @RequestMapping("detail")
    public ModelAndView getUserDetail(Integer id) {
        ModelAndView mv = new ModelAndView("/auth/user_detail");
        UserVO user = id != null ? userService.selectByPrimaryKey(id) : new UserVO();
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody UserVO user) {
        try {
            if (!user.getConfirmPassword().equals(user.getPassword())) {
                return Result.fail("两次输入的密码不一致，请重新输入！");
            }
            if (user.getId() != null) {
                userService.updateUser(user);
            } else {
                userService.addUser(user);
            }
            return Result.suc("操作成功！");
        } catch (Exception e) {
            log.error("业务代码出错！", e);
            return Result.fail("内部错误！" + e.getMessage());
        }
    }

    @RequestMapping("del")
    @ResponseBody
    public Result del(Integer id) {
        try {
            userService.deleteUser(id);
            return Result.suc("操作成功！");
        } catch (Exception e) {
            log.error("业务代码出错！", e);
            return Result.fail("内部错误！" + e.getMessage());
        }
    }

    @RequestMapping("lock")
    @ResponseBody
    public Result lock(Integer id, Integer pastStatus) {
        try {
            userService.lockUser(id, pastStatus);
            return Result.suc("操作成功！");
        } catch (Exception e) {
            log.error("业务代码出错！", e);
            return Result.fail("内部错误！" + e.getMessage());
        }
    }

}
