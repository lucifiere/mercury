package com.atlandes.erp.controller;

import com.atlandes.erp.po.Price;
import com.atlandes.erp.service.PriceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("price")
public class PriceController {

    @Resource
    private PriceServiceImpl priceServiceImpl;

    @RequestMapping("getPrice")
    @ResponseBody
    public Price getPriceById(Integer id){
        return priceServiceImpl.selectPriceById(id);
    }

    @RequestMapping("getPriceList")
    @ResponseBody
    public List<Price> getPriceList(){
        return priceServiceImpl.selectPriceList();
    }

    @RequestMapping("insertPrice")
    @ResponseBody
    public int insertPrice(Price price){
        return priceServiceImpl.insertPrice(price);
    }

    @RequestMapping("updatePrice")
    @ResponseBody
    public int updatePrice(Price price){
        return priceServiceImpl.updatePriceById(price.getId());
    }

    @RequestMapping("deletePrice")
    @ResponseBody
    public void deletePrice(Price price){
        priceServiceImpl.deletePriceById(price.getId());
    }
}
