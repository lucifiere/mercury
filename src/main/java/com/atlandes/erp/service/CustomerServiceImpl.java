package com.atlandes.erp.service;

import com.atlandes.erp.dao.CustomerInfoMapper;
import com.atlandes.erp.po.CustomerInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerInfoMapper customerInfoMapper;

    @Override
    public int insertCustomerInfo(CustomerInfo customerInfo) {
        return customerInfoMapper.insertCustomerInfo(customerInfo);
    }

    @Override
    public CustomerInfo selectCustomerInfoById(int id) {
        return customerInfoMapper.selectCustomerInfoById(id);
    }

    @Override
    public List<CustomerInfo> selectCustomerInfoList() {
        return customerInfoMapper.selectCustomerInfoList();
    }

    @Override
    public List<CustomerInfo> selectCustomerInfoListByPage(Integer pageNum, Integer pageSize) {
        return customerInfoMapper.selectCustomerInfoListByPage(pageNum, pageSize);
    }

    @Override
    public int updateCustomerInfoById(CustomerInfo customerInfo) {
        return customerInfoMapper.updateCustomerInfoById(customerInfo);
    }

    @Override
    public void deleteCustomerInfoById(int id) {
        customerInfoMapper.deleteCustomerInfoById(id);
    }
}
