package com.atlandes.auth.service;

import com.atlandes.auth.dao.UserMapper;
import com.atlandes.auth.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by XD.Wang on 2017/6/2.
 * 用户编辑
 */
@Service
public class UserService {

    @Resource
    private
    UserMapper userMapper;

    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    public User findUserByNickname(String uq) {
        return userMapper.findUserByNickname(uq);
    }

}
