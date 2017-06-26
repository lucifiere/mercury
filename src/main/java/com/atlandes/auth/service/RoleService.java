package com.atlandes.auth.service;

import com.atlandes.auth.dao.RoleMapper;
import com.atlandes.auth.po.Role;
import com.atlandes.auth.vo.RoleVO;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.service.BaseFuncSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XD.Wang on 2017/6/2.
 * 用户编辑
 */
@Service
public class RoleService extends BaseFuncSupport<RoleMapper> {

    @Resource
    private
    RoleMapper roleMapper;

    public Pagination<RoleVO> getRoleList4Page(Pagination query) {
        Pagination<RoleVO> p = exePaging("getRoleList", query, RoleVO.class);
        setPageInfo(p.getResult());
        return p;
    }

    private void setPageInfo(List<RoleVO> list) {
        for (RoleVO role : list) {

        }
    }

    public RoleVO selectByPrimaryKey(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public Integer addRole(RoleVO role) {
        return roleMapper.insertSelective(role);
    }

    public void deleteRole(Integer id) {
        roleMapper.invalidByPrimaryKey(id);
    }

    public void changeStatus(Integer id, Integer status) {
        Role role = new Role();
        role.setStatus(status);
        role.setId(id);
        roleMapper.updateByPrimaryKeySelective(role);
    }

}
