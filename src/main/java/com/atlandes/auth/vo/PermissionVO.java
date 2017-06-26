package com.atlandes.auth.vo;

import com.atlandes.auth.po.Permission;
import org.apache.ibatis.type.Alias;

/**
 * Created by XD.Wang on 2017/6/21.
 */
@Alias("permissionVO")
public class PermissionVO extends Permission {

    private String isValidStr;

    private String statusStr;

    private String typeStr;

    public String getIsValidStr() {
        return isValidStr;
    }

    public void setIsValidStr(String isValidStr) {
        this.isValidStr = isValidStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }
}
