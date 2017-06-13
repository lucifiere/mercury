package com.atlandes.common.enums;

/**
 * Created by XD.Wang on 2017/6/13.
 * 有效性
 */
public enum ValidStatus implements Enum {

    VALID("有效", 1), INVALID("无效", 0);

    private String value;
    private int code;

    ValidStatus(String value, int code) {
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
