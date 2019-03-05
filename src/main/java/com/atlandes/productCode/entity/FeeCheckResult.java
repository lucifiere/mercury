package com.atlandes.productCode.entity;

public class FeeCheckResult {
    private String checkAge;
    private String checkPremium;
    private String checkResult;
    private String checkMark;
    private boolean success;

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

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckMark() {
        return checkMark;
    }

    public void setCheckMark(String checkMark) {
        this.checkMark = checkMark;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
