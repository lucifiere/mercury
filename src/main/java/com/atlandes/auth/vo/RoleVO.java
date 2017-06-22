package com.atlandes.auth.vo;

import com.atlandes.auth.po.Role;

import java.util.List;

/**
 * Created by XD.Wang on 2017/6/22.
 * 角色 可以有多个 权限
 */
public class RoleVO extends Role {

    private List<PermissionVO> permissionList;

    private String isValidStr;

    private String statusStr;

    private String typeStr;

    private String permissionStr;

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getPermissionStr() {
        return permissionStr;
    }

    public void setPermissionStr(String permissionStr) {
        this.permissionStr = permissionStr;
    }

    public List<PermissionVO> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionVO> permissionList) {
        this.permissionList = permissionList;
    }

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
}
