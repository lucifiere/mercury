package com.atlandes.auth.enums;

import com.atlandes.common.enums.Enum;

/**
 * Created by XD.Wang on 2017/6/26.
 */
public enum PermissionStatus implements Enum {

    A("状态A", 0), B("状态B", 1);

    private String value;
    private int code;

    PermissionStatus(String value, int code) {
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
