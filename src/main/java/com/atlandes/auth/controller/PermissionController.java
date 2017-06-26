package com.atlandes.auth.controller;

import com.atlandes.auth.enums.PermissionStatus;
import com.atlandes.auth.enums.PermissionType;
import com.atlandes.auth.service.PermissionService;
import com.atlandes.auth.vo.PermissionQuery;
import com.atlandes.auth.vo.PermissionVO;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.pojo.Result;
import com.atlandes.common.util.EnumUtil;
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
 * Created by XD.Wang on 2017/6/26.
 * 权限
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Resource
    private
    PermissionService permissionService;

    private static final Logger log = LoggerFactory.getLogger(PermissionController.class);

    @RequestMapping("list")
    public ModelAndView getPermissionList(PermissionQuery query) {
        ModelAndView mv = new ModelAndView("/auth/permission");
        Pagination<PermissionVO> paging = PageUtil.getPagingList(var1 -> permissionService.getPermissionList4Page(var1), query);
        mv.addObject("permissionList", paging.getResult());
        mv.addObject("pageTotalCount", paging.getPageTotalCount());
        return mv;
    }

    @RequestMapping("detail")
    public ModelAndView getPermissionDetail(Integer id) {
        ModelAndView mv = new ModelAndView("/auth/permission_detail");
        PermissionVO permission = id != null ? permissionService.selectByPrimaryKey(id) : new PermissionVO();
        mv.addObject("permission", permission);
        mv.addObject("typeList", EnumUtil.getEnumMap(PermissionType.values()));
        mv.addObject("statusList", EnumUtil.getEnumMap(PermissionStatus.values()));
        return mv;
    }

    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody PermissionVO permission) {
        try {
            if (permission.getId() != null) {
                permissionService.updatePermission(permission);
            } else {
                permissionService.addPermission(permission);
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
            permissionService.deletePermission(id);
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
            permissionService.changeStatus(id, pastStatus);
            return Result.suc("操作成功！");
        } catch (Exception e) {
            log.error("内部错误！", e);
            return Result.fail("内部错误！" + e.getMessage());
        }
    }

}
