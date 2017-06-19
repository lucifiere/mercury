package com.atlandes.admin.service;

import com.atlandes.admin.constant.MenuLevel;
import com.atlandes.admin.dao.MenuMapper;
import com.atlandes.admin.po.Menu;
import com.atlandes.admin.vo.MenuQuery;
import com.atlandes.admin.vo.MenuVO;
import com.atlandes.common.enums.ValidStatus;
import com.atlandes.common.enums.VisibleStatus;
import com.atlandes.common.service.BaseFuncSupport;
import com.atlandes.common.util.EnumUtil;
import com.atlandes.common.pojo.Pagination;
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
public class MenuService extends BaseFuncSupport<MenuMapper> {

    @Resource
    private
    MenuMapper menuMapper;

    private static Logger log = Logger.getLogger(MenuService.class);

    public List<MenuVO> groupMenuList() {
        return getMenuListGroupByLevel(menuMapper.getAllMenuList(new MenuQuery()));
    }

    public void setPageInfo(List<MenuVO> list) {
        for (MenuVO menu : list) {
            menu.setLevelStr(EnumUtil.getName(MenuLevel.values(), menu.getLevel()));
            menu.setIsVisibleStr(EnumUtil.getName(VisibleStatus.values(), menu.getIsVisible()));
        }
    }

    public Pagination<MenuVO> getMenuList4Page(Pagination query) {
        Pagination<MenuVO> p = exePaging("getMenuList", query, MenuVO.class);
        setPageInfo(p.getResult());
        return p;
    }

    public MenuVO selectMenuById(int id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    public int addMenu(Menu menu) {
        menu.setIsValid(ValidStatus.VALID.getCode());
        return menuMapper.insert(menu);
    }

    public void deleteMenu(int id) {
        menuMapper.invalidByPrimaryKey(id);
    }

    public int updateMenu(Menu menu) {
        return menuMapper.updateByPrimaryKey(menu);
    }

    private List<MenuVO> getMenuListGroupByLevel(List<MenuVO> sources) {
        List<MenuVO> pageMenuList = new ArrayList<>();
        for (MenuVO source : sources) {
            if (source.getLevel() == MenuLevel.MODULE_MENU_LEVEL.getCode()) {
                List<MenuVO> subMenuList = new ArrayList<>();
                for (MenuVO m : sources) {
                    if (m.getParentCode() != null && m.getParentCode().equals(source.getCode())
                            && m.getIsVisible() == VisibleStatus.VISIBLE.getCode()) {
                        subMenuList.add(m);
                    }
                }
                if (source.getIsVisible() == VisibleStatus.VISIBLE.getCode()) {
                    source.setChildren(subMenuList);
                    pageMenuList.add(source);
                }
            }
        }
        return pageMenuList;
    }

}
