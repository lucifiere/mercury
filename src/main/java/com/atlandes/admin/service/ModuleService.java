package com.atlandes.admin.service;

import com.atlandes.admin.dao.ModuleMapper;
import com.atlandes.admin.po.Module;
import com.atlandes.admin.vo.ModuleQuery;
import com.atlandes.admin.vo.ModuleVO;
import com.atlandes.common.enums.ValidStatus;
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
    private ModuleMapper moduleMapper;

    //添加模块
    public int addModule(Module baseInfo) {
        baseInfo.setIsValid(ValidStatus.VALID.getCode());
        return moduleMapper.insert(baseInfo);
    }

    //更新模块
    public void updateModule(Module baseInfo) {
        moduleMapper.updateByPrimaryKey(baseInfo);
    }

    //删除模块
    public void deleteModule(Integer id) {
        moduleMapper.invalidByPrimaryKey(id);
    }

    //获取模块列表
    public List<ModuleVO> getModuleList(ModuleQuery query) {
        return moduleMapper.getModuleList(query);
    }

    //根据id查询模块
    public ModuleVO selectModuleById(Integer id) {
        return moduleMapper.selectByPrimaryKey(id);
    }

}
