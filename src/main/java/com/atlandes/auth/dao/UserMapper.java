package com.atlandes.auth.dao;

import com.atlandes.auth.bo.UserBO;
import com.atlandes.auth.po.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(Map<String, Object> map);

    User findUserByNickname(String name);

    List<UserBO> selectRoleByNickname(String nickname);

}