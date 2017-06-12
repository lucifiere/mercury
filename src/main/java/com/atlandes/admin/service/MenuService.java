package com.atlandes.admin.service;

import com.atlandes.admin.constant.MenuConstant;
import com.atlandes.admin.dao.MenuMapper;
import com.atlandes.admin.po.Menu;
import com.atlandes.admin.vo.MenuVO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统菜单管理service层
 * Created by C.Liu on 2017/06/04.
 */
@Service
public class MenuService {

    @Resource
    private
    MenuMapper menuMapper;

    private static Logger log = Logger.getLogger(MenuService.class);


    public List<MenuVO> getMenuList() {
        return getMenuListGroupByLevel(menuMapper.getMenuList());
    }

    public List<MenuVO> getMenuListCount() {
        return getMenuListGroupByLevel(menuMapper.getMenuList());
    }

    private List<MenuVO> getMenuListGroupByLevel(List<Menu> sources) {
        List<MenuVO> pageMenuList = new ArrayList<MenuVO>();
        for (Menu source : sources) {
            if (source.getLevel() == MenuConstant.MODULE_MENU_LEVEL) {
                List<MenuVO> subMenuList = new ArrayList<MenuVO>();
                for (Menu m : sources) {
                    if (m.getParentCode() != null && m.getParentCode().equals(source.getCode())) {
                        subMenuList.add(getMenuVOFromMenu(m, null));
                    }
                }
                pageMenuList.add(getMenuVOFromMenu(source, subMenuList));
            }
        }
        return pageMenuList;
    }

    private MenuVO getMenuVOFromMenu(Menu menu, List<MenuVO> subMenuList) {
        MenuVO vo = new MenuVO();
        vo.setCode(menu.getCode());
        vo.setIsVisible(menu.getIsVisible());
        vo.setName(menu.getName());
        vo.setRemark(menu.getRemark());
        vo.setUrl(menu.getUrl());
        vo.setChildren(subMenuList);
        return vo;
    }

    public Menu selectMenuById(int id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    public int addMenu(Menu menu) {
        return menuMapper.insert(menu);
    }

    public int deleteMenu(int id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    public int updateMenu(Menu menu) {
        return menuMapper.updateByPrimaryKey(menu);
    }

}
