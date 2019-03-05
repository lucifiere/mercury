package com.atlandes.productCode.entity;

import java.util.List;

public class ProductDict {

    private List<Dict> sex;
    private List<Dict> periods;
    private List<Dict> payPeriod;
    private List<Dict> socialSecurity;
    private Dict age;

    public Dict getAge() {
        return age;
    }

    public void setAge(Dict age) {
        this.age = age;
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
