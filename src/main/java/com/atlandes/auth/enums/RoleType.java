package com.atlandes.auth.enums;

import com.atlandes.common.enums.Enum;

/**
 * Created by XD.Wang on 2017/6/26.
 */
public enum RoleType implements Enum {

    A("类型A", 0), B("类型B", 1);

    private String value;
    private int code;

    RoleType(String value, int code) {
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
