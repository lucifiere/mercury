package com.atlandes.auth.dao;

import com.atlandes.auth.po.Role;
import com.atlandes.auth.vo.RoleVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RoleMapper {

    int deleteByPrimaryKey(Integer id);

    void invalidByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    RoleVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Set<String> findRoleByUserId(Integer id);

    List<RoleVO> findNowAllPermission(Map<String, Object> map);

    void initData();

}