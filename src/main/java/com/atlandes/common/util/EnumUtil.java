package com.atlandes.common.util;

import com.atlandes.common.enums.Enum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XD.Wang on 2017/6/13.
 * 枚举工具类
 */
public class EnumUtil {

    private EnumUtil() {
    }

    // 获取枚举名
    public static String getName(Enum[] arrays, int code) {
        for (Enum status : arrays) {
            if (status.getCode() == code) {
                return status.getValue();
            }
        }
        return "";
    }

    // 将Enum转换为Map
    public static Map<String, Integer> getEnumMap(Enum[] arrays) {
        Map<String, Integer> res = new HashMap<>();
        for (Enum e : arrays) {
            res.put(e.getValue(), e.getCode());
        }
        return res;
    }

}
