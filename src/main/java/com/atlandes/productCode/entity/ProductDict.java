package com.atlandes.productCode.entity;

import java.util.List;

public class ProductDict {

    private List<Dict> sex;
    private List<Dict> periods;
    private List<Dict> payPeriod;
    private List<Dict> socialSecurity;
    private List<Dict> amount;
    public List<Dict> getAmount() {
        return amount;
    }

    public void setAmount(List<Dict> amount) {
        this.amount = amount;
    }


    private String minAge;
    private String maxAge;

    public String getMinAge() {
        return minAge;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public String getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }


    public List<Dict> getSex() {
        return sex;
    }

    public void setSex(List<Dict> sex) {
        this.sex = sex;
    }


    public List<Dict> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Dict> periods) {
        this.periods = periods;
    }

    public List<Dict> getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(List<Dict> payPeriod) {
        this.payPeriod = payPeriod;
    }

    public List<Dict> getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(List<Dict> socialSecurity) {
        this.socialSecurity = socialSecurity;
    }
}
