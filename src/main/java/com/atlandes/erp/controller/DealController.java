package com.atlandes.erp.controller;

import com.alibaba.fastjson.JSON;
import com.atlandes.erp.po.Deal;
import com.atlandes.erp.service.DealServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("deal")
public class DealController {

    @Resource
    private DealServiceImpl dealServiceImpl;

    @RequestMapping("getDeal")
    @ResponseBody
    public String getDealDetail(Integer id){
        return JSON.toJSONString(dealServiceImpl.selectDealById(id));
    }

    @RequestMapping("getDealList")
    @ResponseBody
    public String getDealList(){
        return JSON.toJSONString(dealServiceImpl.selectDealList());
    }

    @RequestMapping("insert")
    @ResponseBody
    public int insertDeal(Deal deal){
        return dealServiceImpl.insertDeal(deal);
    }

    @RequestMapping("update")
    @ResponseBody
    public int updateDeal(Deal deal){
        return dealServiceImpl.updateDealById(deal);
    }

    @RequestMapping("delete")
    @ResponseBody
    public void deleteDeal(Integer id){
        dealServiceImpl.deleteDealById(id);
    }
}
