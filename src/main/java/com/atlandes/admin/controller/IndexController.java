package com.atlandes.admin.controller;

import com.atlandes.admin.service.MenuService;
import com.atlandes.admin.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by XD.Wang on 2017/6/7.
 * 主页
 */
@Controller
@RequestMapping("admin")
public class IndexController {

    @Resource
    private
    MenuService menuService;

    @Resource
    private
    ModuleService moduleService;

    @RequestMapping("index")
    public ModelAndView toIndexPage() {
        ModelAndView mv = new ModelAndView("admin/index");
        mv.addObject("menuList", menuService.groupMenuList());
        mv.addObject("currUserName", "XD.Wang");
        mv.addObject("moduleList", moduleService.getModuleList());
        return mv;
    }

}
