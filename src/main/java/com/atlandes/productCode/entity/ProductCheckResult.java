package com.atlandes.productCode.entity;

public class ProductCheckResult {
    private String underWriteResult;
    private String issueResult;
    private String onLinePolicyResult;
    private String underWriteOnceMoreResult;
    private String issueOnceMoreResult;
    private String issueIdempotentResult;

    public String getUnderWriteOnceMoreResult() {
        return underWriteOnceMoreResult;
    }

    public void setUnderWriteOnceMoreResult(String underWriteOnceMoreResult) {
        this.underWriteOnceMoreResult = underWriteOnceMoreResult;
    }

    public String getIssueOnceMoreResult() {
        return issueOnceMoreResult;
    }

    public void setIssueOnceMoreResult(String issueOnceMoreResult) {
        this.issueOnceMoreResult = issueOnceMoreResult;
    }

    public String getIssueIdempotentResult() {
        return issueIdempotentResult;
    }

    public void setIssueIdempotentResult(String issueIdempotentResult) {
        this.issueIdempotentResult = issueIdempotentResult;
    }
    public String getOnLinePolicyResult() {
        return onLinePolicyResult;
    }
    public void setOnLinePolicyResult(String onLinePolicyResult) {
        this.onLinePolicyResult = onLinePolicyResult;
    }
    public String getUnderWriteResult() {
        return underWriteResult;
    }

    public void setUnderWriteResult(String underWriteResult) {
        this.underWriteResult = underWriteResult;
    }

    public String getIssueResult() {
        return issueResult;
    }

    public void setIssueResult(String issueResult) {
        this.issueResult = issueResult;
    }
}
