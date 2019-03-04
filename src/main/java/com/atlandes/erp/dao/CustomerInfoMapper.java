package com.atlandes.erp.dao;

import com.atlandes.erp.po.CustomerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerInfoMapper {

    int insertCustomerInfo(CustomerInfo customerInfo);

    CustomerInfo selectCustomerInfoById(int id);

    List<CustomerInfo> selectCustomerInfoList();

    List<CustomerInfo> selectCustomerInfoListByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    int updateCustomerInfoById(CustomerInfo customerInfo);

    void deleteCustomerInfoById(int id);
}
