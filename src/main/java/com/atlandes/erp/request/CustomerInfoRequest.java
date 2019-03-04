package com.atlandes.erp.request;

/**
 * Created by Tyler.Wang on 2019/3/4 0004.
 * 客户信息
 */
public class CustomerInfoRequest {

    /**
     * 客户ID
     */
    private Integer id;

    private String driverName;

    private String companyName;
    
    private String companyAddress;
    
    private Integer companyCredit;
    
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Integer getCompanyCredit() {
        return companyCredit;
    }

    public void setCompanyCredit(Integer companyCredit) {
        this.companyCredit = companyCredit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
