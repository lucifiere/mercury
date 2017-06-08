package com.atlandes.admin.dao;

import com.atlandes.admin.po.Module;

import java.util.List;

public interface ModuleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> getModuleList();

}