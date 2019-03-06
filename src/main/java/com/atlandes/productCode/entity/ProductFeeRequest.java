package com.atlandes.productCode.entity;

public class ProductFeeRequest {

    private String productCode;
    private String periods;
    private String payPeriod;
    private String socialSecurity;
    private String sex;
    private String amount;
    private String minAge;
    private String maxAge;
    private String holderInsuredRelations;

    public String getHolderInsuredRelations() {
        return holderInsuredRelations;
    }

    public void setHolderInsuredRelations(String holderInsuredRelations) {
        this.holderInsuredRelations = holderInsuredRelations;
    }


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

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
}
