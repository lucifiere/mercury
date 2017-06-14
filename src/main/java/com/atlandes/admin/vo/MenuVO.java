package com.atlandes.admin.vo;

import com.atlandes.admin.po.Menu;

import java.util.List;

/**
 * Created by XD.Wang on 2017/6/8.
 * 菜单
 */
public class MenuVO extends Menu {

    private List<MenuVO> children;

    // 页面字段
    private String levelStr;

    private String isVisibleStr;

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }

    public String getLevelStr() {
        return levelStr;
    }

    public void setLevelStr(String levelStr) {
        this.levelStr = levelStr;
    }

    public String getIsVisibleStr() {
        return isVisibleStr;
    }

    public void setIsVisibleStr(String isVisibleStr) {
        this.isVisibleStr = isVisibleStr;
    }
}
