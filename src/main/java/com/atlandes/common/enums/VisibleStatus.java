package com.atlandes.common.enums;

/**
 * Created by XD.Wang on 2017/6/13.
 * 可见性
 */
public enum VisibleStatus implements Enum {

    VISIBLE("可见", 1), INVISIBLE("不可见", 0);

    private String value;
    private int code;

    VisibleStatus(String value, int code) {
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
