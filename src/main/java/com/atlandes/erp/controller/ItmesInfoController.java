package com.atlandes.erp.controller;

import com.alibaba.fastjson.JSON;
import com.atlandes.erp.po.ItemsInfo;
import com.atlandes.erp.service.ItemsInfoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("items")
public class ItmesInfoController {

    @Resource
    private ItemsInfoServiceImpl itemsInfoService;

    @RequestMapping("getItemsInfo")
    @ResponseBody
    public ItemsInfo getItemsInfoById(Integer id){
        return itemsInfoService.selectItemsInfoById(id);
    }

    @RequestMapping("infoList")
    @ResponseBody
    public String getItemsInfoList(){
        return JSON.toJSONString(itemsInfoService.selectItemsInfoList());
    }

    @RequestMapping("insert")
    @ResponseBody
    public Integer insertItemsInfo(ItemsInfo itemsInfo){
        return itemsInfoService.insertItemsInfo(itemsInfo);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String deleteItemsInfo(Integer id){
        itemsInfoService.deleteItemsInfoById(id);
        return "删除成功";
    }
}
