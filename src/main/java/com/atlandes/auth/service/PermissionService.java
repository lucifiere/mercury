package com.atlandes.auth.service;

import com.atlandes.auth.dao.PermissionMapper;
import com.atlandes.auth.po.Permission;
import com.atlandes.auth.vo.PermissionVO;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.service.BaseFuncSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by XD.Wang on 2017/6/2.
 * 用户编辑
 */
@Service
public class PermissionService extends BaseFuncSupport<PermissionMapper> {

    @Resource
    private
    PermissionMapper permissionMapper;

    public Pagination<PermissionVO> getPermissionList4Page(Pagination query) {
        Pagination<PermissionVO> p = exePaging("getPermissionList", query, PermissionVO.class);
        setPageInfo(p.getResult());
        return p;
    }

    private void setPageInfo(List<PermissionVO> list) {
        for (PermissionVO permission : list) {

        }
    }

    public PermissionVO selectByPrimaryKey(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    public void updatePermission(Permission permission) {
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    public Integer addPermission(Permission permission) {
        return permissionMapper.insertSelective(permission);
    }

    public void deletePermission(Integer id) {
        permissionMapper.invalidByPrimaryKey(id);
    }

    public void changeStatus(Integer id, Integer status) {
        Permission permission = new Permission();
        permission.setStatus(status);
        permission.setId(id);
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    public Set<String> findPermissionUrlByRoleIds(String ids){
        return permissionMapper.findPermissionUrlByRoleIds(ids);
    }


}
