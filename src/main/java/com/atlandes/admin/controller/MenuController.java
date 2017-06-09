package com.atlandes.admin.controller;

import com.atlandes.admin.service.MenuService;
import com.atlandes.admin.vo.MenuQuery;
import com.atlandes.admin.vo.MenuVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XD.Wang on 2017/6/9.
 * 菜单管理
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Resource
    private
    MenuService menuService;

    @RequestMapping("list")
    public ModelAndView getMenuList(MenuQuery query) {
        ModelAndView mv = new ModelAndView("/admin/menu");
        List<MenuVO> menuList = menuService.getMenuList();
        mv.addObject("menuList", menuList);
        return mv;
    }

}
