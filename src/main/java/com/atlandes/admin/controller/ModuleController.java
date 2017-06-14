package com.atlandes.admin.controller;

import com.alibaba.fastjson.JSON;
import com.atlandes.admin.po.Module;
import com.atlandes.admin.service.ModuleService;
import com.atlandes.admin.vo.ModuleQuery;
import com.atlandes.admin.vo.ModuleVO;
import com.atlandes.common.pojo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XD.Wang on 2017/6/14.
 * 模块
 */
@Controller
@RequestMapping("module")
public class ModuleController {

    @Resource
    private ModuleService moduleService;

    @RequestMapping("list")
    public ModelAndView getModuleList(ModuleQuery query) {
        ModelAndView mv = new ModelAndView("/admin/module");
        List<ModuleVO> moduleList = moduleService.getModuleList(query);
        mv.addObject("moduleList", moduleList);
        mv.addObject("pageCond", moduleService.getModulePageCond(query));
        return mv;
    }

    @RequestMapping("detail")
    public ModelAndView getModuleDetail(Integer id) {
        ModelAndView mv = new ModelAndView("/admin/module_detail");
        ModuleVO module = id != null ? moduleService.selectModuleById(id) : new ModuleVO();
        mv.addObject("module", module);
        return mv;
    }

    @RequestMapping("edit")
    public String edit(Module module) {
        try {
            if (module.getId() != null) {
                moduleService.updateModule(module);
            } else {
                moduleService.addModule(module);
            }
            return "redirect:/module/list";
        } catch (Exception e) {
            return JSON.toJSONString(Result.fail(e.getMessage()));
        }
    }

    @RequestMapping("del")
    public String del(Integer id) {
        try {
            moduleService.deleteModule(id);
            return "redirect:/module/list";
        } catch (Exception e) {
            return JSON.toJSONString(Result.fail(e.getMessage()));
        }
    }

}
