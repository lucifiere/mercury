package com.atlandes.auth.vo;

import com.atlandes.auth.po.User;

import java.util.List;

/**
 * Created by XD.Wang on 2017/6/20.
 * 用户 可以有多个 角色
 */
public class UserVO extends User {

    private String confirmPassword;

    private String isValidStr;

    private String isLockedStr;

    private String statusStr;

    private List<RoleVO> roleList;

    public List<RoleVO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleVO> roleList) {
        this.roleList = roleList;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getIsValidStr() {
        return isValidStr;
    }

    public void setIsValidStr(String isValidStr) {
        this.isValidStr = isValidStr;
    }

    public String getIsLockedStr() {
        return isLockedStr;
    }

    public void setIsLockedStr(String isLockedStr) {
        this.isLockedStr = isLockedStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
