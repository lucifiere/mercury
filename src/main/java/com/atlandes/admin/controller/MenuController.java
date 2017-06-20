package com.atlandes.admin.controller;

import com.alibaba.fastjson.JSON;
import com.atlandes.admin.po.Menu;
import com.atlandes.admin.service.MenuService;
import com.atlandes.admin.vo.MenuQuery;
import com.atlandes.admin.vo.MenuVO;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.pojo.Result;
import com.atlandes.common.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

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
        Pagination<MenuVO> paging = PageUtil.getPagingList(var -> menuService.getMenuList4Page(var), query);
        mv.addObject("menuList", paging.getResult());
        mv.addObject("pageTotalCount", paging.getPageTotalCount());
        return mv;
    }

    @RequestMapping("detail")
    public ModelAndView getMenuDetail(Integer id) {
        ModelAndView mv = new ModelAndView("/admin/menu_detail");
        MenuVO menu = id != null ? menuService.selectMenuById(id) : new MenuVO();
        mv.addObject("menu", menu);
        return mv;
    }

    @RequestMapping("edit")
    public String edit(Menu menu) {
        try {
            if (menu.getId() != null) {
                menuService.updateMenu(menu);
            } else {
                menuService.addMenu(menu);
            }
            return "redirect:/menu/list";
        } catch (Exception e) {
            return JSON.toJSONString(Result.fail(e.getMessage()));
        }
    }

    @RequestMapping("del")
    public String del(Integer id) {
        try {
            menuService.deleteMenu(id);
            return "redirect:/menu/list";
        } catch (Exception e) {
            return JSON.toJSONString(Result.fail(e.getMessage()));
        }
    }

}
