package com.atlandes.erp.service;

import com.atlandes.erp.po.CustomerInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    int insertCustomerInfo(CustomerInfo customerInfo);

    CustomerInfo selectCustomerInfoById(int id);

    List<CustomerInfo> selectCustomerInfoList();

    List<CustomerInfo> selectCustomerInfoListByPage(Integer pageNum, Integer pageSize);

    int updateCustomerInfoById(CustomerInfo customerInfo);

    void deleteCustomerInfoById(int id);





}
