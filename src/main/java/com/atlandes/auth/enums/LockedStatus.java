package com.atlandes.auth.enums;

import com.atlandes.common.enums.Enum;

/**
 * Created by XD.Wang on 2017/6/21.
 * 用户锁定状态
 */
public enum LockedStatus implements Enum {

    LOCKED("锁定", 1), UNLOCKED("正常", 0);

    private String value;
    private int code;

    LockedStatus(String value, int code) {
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
