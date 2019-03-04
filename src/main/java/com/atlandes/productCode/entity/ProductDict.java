package com.atlandes.productCode.entity;

import java.util.List;

public class ProductDict {
    private List<Dict> periods;
    private List<Dict> payPeriod;
    private List<Dict> socialSecurity;

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
