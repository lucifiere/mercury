package com.jd.baoxian.test.tools.entity;

public class ProductCheckResult {
    private BaseCheckResult underWriteResult;
    private BaseCheckResult issueResult;
    private BaseCheckResult onLinePolicyResult;
    private BaseCheckResult underWriteOnceMoreResult;
    private BaseCheckResult issueOnceMoreResult;
    private BaseCheckResult issueIdempotentResult;


    public BaseCheckResult getUnderWriteResult() {
        return underWriteResult;
    }

    public void setUnderWriteResult(BaseCheckResult underWriteResult) {
        this.underWriteResult = underWriteResult;
    }

    public BaseCheckResult getIssueResult() {
        return issueResult;
    }

    public void setIssueResult(BaseCheckResult issueResult) {
        this.issueResult = issueResult;
    }

    public BaseCheckResult getOnLinePolicyResult() {
        return onLinePolicyResult;
    }

    public void setOnLinePolicyResult(BaseCheckResult onLinePolicyResult) {
        this.onLinePolicyResult = onLinePolicyResult;
    }

    public BaseCheckResult getUnderWriteOnceMoreResult() {
        return underWriteOnceMoreResult;
    }

    public void setUnderWriteOnceMoreResult(BaseCheckResult underWriteOnceMoreResult) {
        this.underWriteOnceMoreResult = underWriteOnceMoreResult;
    }

    public BaseCheckResult getIssueOnceMoreResult() {
        return issueOnceMoreResult;
    }

    public void setIssueOnceMoreResult(BaseCheckResult issueOnceMoreResult) {
        this.issueOnceMoreResult = issueOnceMoreResult;
    }

    public BaseCheckResult getIssueIdempotentResult() {
        return issueIdempotentResult;
    }

    public void setIssueIdempotentResult(BaseCheckResult issueIdempotentResult) {
        this.issueIdempotentResult = issueIdempotentResult;
    }
}
