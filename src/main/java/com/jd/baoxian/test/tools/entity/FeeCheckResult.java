package com.jd.baoxian.test.tools.entity;

import java.util.List;

public class FeeCheckResult {

    private List<BaseCheckResult> feeCheckResult;
    private boolean success;
    public List<BaseCheckResult> getFeeCheckResult() {
        return feeCheckResult;
    }

    public void setFeeCheckResult(List<BaseCheckResult> feeCheckResult) {
        this.feeCheckResult = feeCheckResult;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}
