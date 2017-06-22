package com.atlandes.auth.controller;

import com.atlandes.auth.service.RoleService;
import com.atlandes.auth.vo.RoleQuery;
import com.atlandes.auth.vo.RoleVO;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.pojo.Result;
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
@RequestMapping("/role")
public class RoleController {

    @Resource
    private
    RoleService roleService;

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @RequestMapping("list")
    public ModelAndView getRoleList(RoleQuery query) {
        ModelAndView mv = new ModelAndView("/auth/role");
        Pagination<RoleVO> paging = PageUtil.getPagingList(var1 -> roleService.getRoleList4Page(var1), query);
        mv.addObject("roleList", paging.getResult());
        mv.addObject("pageTotalCount", paging.getPageTotalCount());
        return mv;
    }

    @RequestMapping("detail")
    public ModelAndView getRoleDetail(Integer id) {
        ModelAndView mv = new ModelAndView("/auth/role_detail");
        RoleVO role = id != null ? roleService.selectByPrimaryKey(id) : new RoleVO();
        mv.addObject("role", role);
        return mv;
    }

    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody RoleVO role) {
        try {
            if (role.getId() != null) {
                roleService.updateRole(role);
            } else {
                roleService.addRole(role);
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
            roleService.deleteRole(id);
            return Result.suc("操作成功！");
        } catch (Exception e) {
            log.error("业务代码出错！", e);
            return Result.fail("内部错误！" + e.getMessage());
        }
    }

    @RequestMapping("changeStatus")
    @ResponseBody
    public Result changeStatus(Integer id, Integer pastStatus) {
        try {
            roleService.changeStatus(id, pastStatus);
            return Result.suc("操作成功！");
        } catch (Exception e) {
            log.error("业务代码出错！", e);
            return Result.fail("内部错误！" + e.getMessage());
        }
    }

}
