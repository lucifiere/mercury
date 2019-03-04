package com.atlandes.erp.controller;


import com.alibaba.fastjson.JSON;
import com.atlandes.erp.po.CustomerInfo;
import com.atlandes.erp.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerInfoController {

    @Resource
    private CustomerServiceImpl customerServiceImpl;


    @RequestMapping("getCustomer")
    @ResponseBody
    public CustomerInfo getCustomerInfoDetail(Integer id){
        CustomerInfo customerInfo = customerServiceImpl.selectCustomerInfoById(id);
        return customerInfo;
    }

    @RequestMapping("getCustomerList")
    @ResponseBody
    public String getCustomerInfoList(){
        List<CustomerInfo> customerInfoList = customerServiceImpl.selectCustomerInfoList();
        return JSON.toJSONString(customerInfoList);
    }

    @RequestMapping("getCustomerListByPage")
    @ResponseBody
    public String getCustomerInfoListByPage(Integer pageNum, Integer pageSize){
        List<CustomerInfo> customerInfoList = customerServiceImpl.selectCustomerInfoListByPage(pageNum, pageSize);
        return JSON.toJSONString(customerInfoList);
    }

    @RequestMapping("insert")
    @ResponseBody
    public int insertCustomerInfo(CustomerInfo customerInfo){
        return customerServiceImpl.insertCustomerInfo(customerInfo);
    }

    @RequestMapping("update")
    @ResponseBody
    public int updateCustomerInfo(CustomerInfo customerInfo){
        return customerServiceImpl.updateCustomerInfoById(customerInfo);
    }

    @RequestMapping("delete")
    @ResponseBody
    public void deleteCustomerInfo(Integer id){
        customerServiceImpl.deleteCustomerInfoById(id);
    }
}
