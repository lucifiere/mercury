package com.atlandes.productCode.entity;

public class BaseCheckResult {
    private String checkItem;
    private String checkResult;
    private String checkResultDesc;
    private String checkMark;
    private String checkAge;
    private String checkPremium;


    public String getCheckAge() {
        return checkAge;
    }

    public void setCheckAge(String checkAge) {
        this.checkAge = checkAge;
    }

    public String getCheckPremium() {
        return checkPremium;
    }

    public void setCheckPremium(String checkPremium) {
        this.checkPremium = checkPremium;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckResultDesc() {
        return checkResultDesc;
    }

    public void setCheckResultDesc(String checkResultDesc) {
        this.checkResultDesc = checkResultDesc;
    }

    public String getCheckMark() {
        return checkMark;
    }

    public void setCheckMark(String checkMark) {
        this.checkMark = checkMark;
    }
}
