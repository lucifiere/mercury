package com.atlandes.auth.dao;

import com.atlandes.auth.bo.UserBO;
import com.atlandes.auth.po.User;
import com.atlandes.auth.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    void invalidByPrimaryKey(Integer id);

    int insert(User record);

    void lockUser(Map user);

    int insertSelective(User record);

    UserVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(Map<String, Object> map);

    User findUserByNickname(String name);

    List<UserBO> selectRoleByNickname(String nickname);

}