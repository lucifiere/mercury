package com.atlandes.admin.dao;

import com.atlandes.admin.po.Module;
import com.atlandes.admin.vo.ModuleQuery;
import com.atlandes.admin.vo.ModuleVO;

import java.util.List;

public interface ModuleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    ModuleVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<ModuleVO> getModuleList(ModuleQuery query);

    Integer getModuleListCount();

    void invalidByPrimaryKey(Integer id);

}