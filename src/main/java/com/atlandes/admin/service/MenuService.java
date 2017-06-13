package com.atlandes.admin.service;

import com.atlandes.admin.constant.DefaultPageConfig;
import com.atlandes.admin.constant.MenuLevel;
import com.atlandes.admin.dao.MenuMapper;
import com.atlandes.admin.po.Menu;
import com.atlandes.admin.vo.MenuQuery;
import com.atlandes.admin.vo.MenuVO;
import com.atlandes.common.pojo.PageCond;
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

    public List<MenuVO> groupMenuList() {
        return getMenuListGroupByLevel(menuMapper.getMenuList(new MenuQuery()));
    }

    public List<MenuVO> getMenuList(MenuQuery query) {
        query.setPageCurCount(query.getPageCurCount() * DefaultPageConfig.DEFAULT_PAGE_SIZE);
        return menuMapper.getMenuList(query);
    }

    public PageCond getMenuPageCond(MenuQuery query) {
        PageCond pageCond = new PageCond();
        int pageTotalCount = menuMapper.getMenuListCount();
        pageCond.setPageSize(DefaultPageConfig.DEFAULT_PAGE_SIZE);
        pageCond.setPageCurCount(query.getPageCurCount() * DefaultPageConfig.DEFAULT_PAGE_SIZE);
        pageCond.setPageTotalCount(Math.round(pageTotalCount / DefaultPageConfig.DEFAULT_PAGE_SIZE) + 1);
        return pageCond;
    }

    private List<MenuVO> getMenuListGroupByLevel(List<MenuVO> sources) {
        List<MenuVO> pageMenuList = new ArrayList<MenuVO>();
        for (MenuVO source : sources) {
            if (source.getLevel() == MenuLevel.MODULE_MENU_LEVEL.getCode()) {
                List<MenuVO> subMenuList = new ArrayList<MenuVO>();
                for (MenuVO m : sources) {
                    if (m.getParentCode() != null && m.getParentCode().equals(source.getCode())) {
                        subMenuList.add(getMenuVOFromMenu(m, null));
                    }
                }
                pageMenuList.add(getMenuVOFromMenu(source, subMenuList));
            }
        }
        return pageMenuList;
    }

    private MenuVO getMenuVOFromMenu(MenuVO menu, List<MenuVO> subMenuList) {
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
