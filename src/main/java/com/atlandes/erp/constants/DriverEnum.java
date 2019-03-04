package com.atlandes.erp.constants;

import java.util.Objects;

/**
 * Created by Tyler.Wang on 2019/3/4 0004.
 * 设备映射
 */
public enum DriverEnum {

    PRINTER(1, "打印机"),
    DISPLAY(2, "显示器");

    private int id;

    private String desc;

    DriverEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据id获取对应的设备枚举
     *
     * @param id 设备枚举的ID
     * @return 相应的设备枚举
     */
    public static DriverEnum getDriverEnumById(Integer id) {
        for (DriverEnum curEnum : DriverEnum.values()) {
            if (curEnum.getId() == id) {
                return curEnum;
            }
        }
        return null;
    }

    /**
     * 根据desc获取对应的设备枚举
     *
     * @param desc 设备枚举的ID
     * @return 相应的设备枚举
     */
    public static DriverEnum getDriverEnumByDesc(String desc) {
        for (DriverEnum curEnum : DriverEnum.values()) {
            // Objects.equals用来判断对象内容是否相同，比如字符串的内容是否相同，字符串比较不嫩使用==或！=
            if (Objects.equals(curEnum.getDesc(), desc)) {
                return curEnum;
            }
        }
        return null;
    }

}
