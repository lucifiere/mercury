package com.atlandes.admin.service;

import com.atlandes.admin.dao.ModuleMapper;
import com.atlandes.admin.po.Module;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类描述：基础信息service层
 * Created by C.Liu on 2017/05/26.
 */
@Service
public class ModuleService {

    @Resource
    private ModuleMapper baseInfoMapper;

    //添加模块
    public int add(Module baseInfo) {
        return baseInfoMapper.insert(baseInfo);
    }

    //更新模块
    public void update(Module baseInfo) {
        baseInfoMapper.updateByPrimaryKey(baseInfo);
    }

    //删除模块
    public void delete(Integer id) {
        baseInfoMapper.deleteByPrimaryKey(id);
    }

    //获取模块列表
    public List<Module> getModuleList() {
        List<Module> moduleList = baseInfoMapper.getModuleList();
        return moduleList;
    }

    //根据id查询模块
    public Module selectModuleById(Integer id) {
        Module baseInfo = baseInfoMapper.selectByPrimaryKey(id);
        return baseInfo;
    }
}
