package com.atlandes.auth.bo;

/**
 * Created by XD.Wang on 2017/5/26.
 * 用户角色分配
 */
public class RoleAllocationBO {

    private static final long serialVersionUID = 1L;

    // 角色名从列转行，逗号分割
    private String roleNames;
    // 角色ID从列转行，以逗号分割
    private String roleIds;

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

}
