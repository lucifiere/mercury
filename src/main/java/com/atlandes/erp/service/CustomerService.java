package com.atlandes.erp.service;

import com.atlandes.erp.po.CustomerInfo;
import com.atlandes.erp.request.CustomerInfoRequest;
import com.atlandes.erp.vo.CustomerInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    int insertCustomerInfo(CustomerInfoRequest customerInfo);

    CustomerInfoVO selectCustomerInfoById(int id);

    List<CustomerInfoVO> selectCustomerInfoList();

    List<CustomerInfo> selectCustomerInfoListByPage(Integer pageNum, Integer pageSize);

    int updateCustomerInfoById(CustomerInfoRequest customerInfo);

    void deleteCustomerInfoById(int id);





}
