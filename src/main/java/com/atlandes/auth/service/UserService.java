package com.atlandes.auth.service;

import com.atlandes.auth.bo.UserBO;
import com.atlandes.auth.dao.UserMapper;
import com.atlandes.auth.po.User;
import com.atlandes.auth.vo.UserVO;
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
public class UserService extends BaseFuncSupport<UserMapper> {

    @Resource
    private
    UserMapper userMapper;

    public Pagination<UserVO> getUserList4Page(Pagination query) {
        Pagination<UserVO> p = exePaging("getUserList", query, UserVO.class);
        setPageInfo(p.getResult());
        return p;
    }

    private void setPageInfo(List<UserVO> list) {
        for (UserVO user : list) {
            // todo
        }
    }

    public UserVO selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    public void deleteUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    public User findUserByNickname(String uq) {
        return userMapper.findUserByNickname(uq);
    }

    public List<UserBO> selectRoleByName(String nickname) {
        return userMapper.selectRoleByNickname(nickname);
    }

}
