package com.atlandes.auth.controller;

import com.alibaba.fastjson.JSON;
import com.atlandes.auth.po.User;
import com.atlandes.auth.service.UserService;
import com.atlandes.auth.vo.UserQuery;
import com.atlandes.auth.vo.UserVO;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.pojo.Result;
import com.atlandes.common.service.PaginationQueryService;
import com.atlandes.common.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String edit(User User) {
        try {
            if (User.getId() != null) {
                userService.updateUser(User);
            } else {
                userService.addUser(User);
            }
            return "redirect:/user/list";
        } catch (Exception e) {
            return JSON.toJSONString(Result.fail(e.getMessage()));
        }
    }

    @RequestMapping("del")
    public String del(Integer id) {
        try {
            userService.deleteUser(id);
            return "redirect:/User/list";
        } catch (Exception e) {
            return JSON.toJSONString(Result.fail(e.getMessage()));
        }
    }

}
