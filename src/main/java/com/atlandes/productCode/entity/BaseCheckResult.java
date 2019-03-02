package com.atlandes.productCode.entity;

public class BaseCheckResult {
    private String checkItem;
    private String checkResult;
    private String checkResultDesc;
    private String checkMark;

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
