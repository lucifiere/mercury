package com.atlandes.auth.dao;

import com.atlandes.auth.po.Permission;
import com.atlandes.auth.vo.PermissionVO;

import java.util.List;
import java.util.Set;

public interface PermissionMapper {

    int deleteByPrimaryKey(Integer id);

    void invalidByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    PermissionVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<PermissionVO> selectPermissionById(Integer id);

    Set<String> findPermissionUrlByRoleIds(String ids);

}