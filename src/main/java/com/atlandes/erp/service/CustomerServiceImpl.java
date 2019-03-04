package com.atlandes.erp.service;

import com.atlandes.erp.constants.DriverEnum;
import com.atlandes.erp.dao.CustomerInfoMapper;
import com.atlandes.erp.po.CustomerInfo;
import com.atlandes.erp.request.CustomerInfoRequest;
import com.atlandes.erp.vo.CustomerInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerInfoMapper customerInfoMapper;

    @Override
    public int insertCustomerInfo(CustomerInfoRequest customerInfo) {
        return customerInfoMapper.insertCustomerInfo(customerInfo);
    }

    @Override
    public CustomerInfoVO selectCustomerInfoById(int id) {
        CustomerInfo customerInfo = customerInfoMapper.selectCustomerInfoById(id);
        CustomerInfoVO customerInfoVO = convertCustomerInfo2CustomerInfoVO(customerInfo);
        return customerInfoVO;
    }

    /**
     * 领域模型转化
     * 将数据库传来的PO转换为可以显示到页面的VO对象
     *
     * @param customerInfo po对象
     * @return vo对象
     */
    private CustomerInfoVO convertCustomerInfo2CustomerInfoVO(CustomerInfo customerInfo) {
        CustomerInfoVO customerInfoVO = new CustomerInfoVO();
        customerInfoVO.setCompanyAddress(customerInfo.getCompanyAddress());
        customerInfoVO.setCompanyCredit(customerInfo.getCompanyCredit());
        customerInfoVO.setCompanyName(customerInfo.getCompanyName());
        customerInfoVO.setDriverId(customerInfo.getDriverId());
        customerInfoVO.setId(customerInfo.getId());
        customerInfoVO.setPhone(customerInfo.getPhone());
        // 为设备寻找设备名称
        if (customerInfo.getDriverId() != null) {
            DriverEnum curDriverEnum = DriverEnum.getDriverEnumById(customerInfo.getDriverId());
            if (curDriverEnum != null) {
                customerInfoVO.setDriverName(curDriverEnum.getDesc());
            }
        }
        return customerInfoVO;
    }

    /**
     * 领域模型转化
     * 将前端传来的Req转换为可以存到数据库的PO对象
     *
     * @param customerInfoRequest req对象
     * @return po对象
     */
    private CustomerInfo convertCustomerInfoRequest2CustomerInfo(CustomerInfoRequest customerInfoRequest) {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCompanyAddress(customerInfo.getCompanyAddress());
        customerInfo.setCompanyCredit(customerInfo.getCompanyCredit());
        customerInfo.setCompanyName(customerInfo.getCompanyName());
        customerInfo.setId(customerInfo.getId());
        customerInfo.setPhone(customerInfo.getPhone());
        // 为设备寻找设备ID，StringUtils.isNotEmpty判断字符串是否为空
        if (StringUtils.isNotEmpty(customerInfoRequest.getDriverName())) {
            DriverEnum curDriverEnum = DriverEnum.getDriverEnumByDesc(customerInfoRequest.getDriverName());
            if (curDriverEnum != null) {
                customerInfo.setId(curDriverEnum.getId());
            }
        }
        return customerInfo;
    }

    @Override
    public List<CustomerInfoVO> selectCustomerInfoList() {
        List<CustomerInfo> list = customerInfoMapper.selectCustomerInfoList();
        List<CustomerInfoVO> voList = new ArrayList<>();
        // foreach循环的参数 形参（当前遍历到的对象， 需要遍历的集合）
        for (CustomerInfo curCustomerInfo : list) {
            CustomerInfoVO customerInfoVO = convertCustomerInfo2CustomerInfoVO(curCustomerInfo);
            voList.add(customerInfoVO);
        }
        return voList;
    }

    @Override
    public List<CustomerInfo> selectCustomerInfoListByPage(Integer pageNum, Integer pageSize) {
        return customerInfoMapper.selectCustomerInfoListByPage(pageNum, pageSize);
    }

    @Override
    public int updateCustomerInfoById(CustomerInfoRequest customerInfoReq) {
        CustomerInfo customerInfo = convertCustomerInfoRequest2CustomerInfo(customerInfoReq);
        return customerInfoMapper.updateCustomerInfoById(customerInfo);
    }

    @Override
    public void deleteCustomerInfoById(int id) {
        customerInfoMapper.deleteCustomerInfoById(id);
    }
}
