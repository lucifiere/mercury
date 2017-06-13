package com.atlandes.admin.constant;

import com.atlandes.common.enums.Enum;

/**
 * Created by XD.Wang on 2017/6/13.
 * 菜单级别
 */
public enum MenuLevel implements Enum {

    MODULE_MENU_LEVEL("系统级别", 1), FUNCTION_MENU_LEVEL("功能级别", 2);

    private String value;
    private int code;

    MenuLevel(String value, int code) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public int getCode() {
        return code;
    }

}
