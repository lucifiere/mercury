package com.atlandes.erp.controller;


import com.alibaba.fastjson.JSON;
import com.atlandes.erp.po.CustomerInfo;
import com.atlandes.erp.request.CustomerInfoRequest;
import com.atlandes.erp.service.CustomerServiceImpl;
import com.atlandes.erp.vo.CustomerInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerInfoController {

    @Resource
    private CustomerServiceImpl customerServiceImpl;

    @RequestMapping("getCustomer")
    public CustomerInfoVO getCustomerInfoDetail(Integer id) {
        CustomerInfoVO customerInfo = customerServiceImpl.selectCustomerInfoById(id);
        return customerInfo;
    }

    @RequestMapping("getCustomerList")
    public String getCustomerInfoList() {
        List<CustomerInfoVO> customerInfoList = customerServiceImpl.selectCustomerInfoList();
        return JSON.toJSONString(customerInfoList);
    }

    @RequestMapping("getCustomerListByPage")
    public String getCustomerInfoListByPage(Integer pageNum, Integer pageSize) {
        List<CustomerInfo> customerInfoList = customerServiceImpl.selectCustomerInfoListByPage(pageNum, pageSize);
        return JSON.toJSONString(customerInfoList);
    }

    @RequestMapping("insert")
    public int insertCustomerInfo(CustomerInfoRequest customerInfo) {
        return customerServiceImpl.insertCustomerInfo(customerInfo);
    }

    @RequestMapping("update")
    public int updateCustomerInfo(CustomerInfoRequest customerInfo) {
        return customerServiceImpl.updateCustomerInfoById(customerInfo);
    }

    @RequestMapping("delete")
    public void deleteCustomerInfo(Integer id) {
        customerServiceImpl.deleteCustomerInfoById(id);
    }
}
