package com.atlandes.auth.service;

import com.atlandes.admin.dao.ModuleMapper;
import com.atlandes.admin.po.Module;
import com.atlandes.auth.dao.RoleMapper;
import com.atlandes.auth.dao.UserMapper;
import com.atlandes.auth.po.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by XD.Wang on 2017/6/22.
 */
@Service
public class TestService implements Test {

    @Resource
    private
    RoleMapper roleMapper;

    @Resource
    private
    ModuleMapper moduleMapper;

    @Override
    public void doIt() {
        doIt2();
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    public void doIt2() {
        Role r = new Role();
        r.setName("AAAA");
        roleMapper.insertSelective(r);
        throwIt();
        Module m = new Module();
        m.setName("NBBB");
        moduleMapper.insertSelective(m);
    }

    public void throwIt() {
        throw new RuntimeException("BBBBBBBBB");
    }

}
