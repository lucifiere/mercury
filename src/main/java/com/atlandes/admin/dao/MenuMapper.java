package com.atlandes.admin.dao;

import com.atlandes.admin.po.Menu;
import com.atlandes.admin.vo.MenuQuery;
import com.atlandes.admin.vo.MenuVO;

import java.util.List;

public interface MenuMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    MenuVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKeyWithBLOBs(Menu record);

    int updateByPrimaryKey(Menu record);

    List<MenuVO> getMenuList(MenuQuery query);

    Integer getMenuListCount();

}