package com.atlandes.erp.po;

public class CustomerInfo {
    //客户编号
    private Integer id;
    //客户司机编号
    private Integer driverId;
    //公司名称
    private String companyName;
    //公司地址
    private String companyAddress;
    //信用度
    private Integer companyCredit;
    //联系方式
    private String phone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
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
}
