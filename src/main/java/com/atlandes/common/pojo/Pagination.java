package com.atlandes.common.pojo;

import java.util.List;

/**
 * Created by XD.Wang on 2017/6/19.
 * 分页
 */
public class Pagination<R> {

    private int pageSize;

    private Integer pageCurCount;

    private Integer offset;

    private String limitSql;

    private Integer pageTotalCount;

    private List<R> result;

    public List<R> getResult() {
        return result;
    }

    public void setResult(List<R> result) {
        this.result = result;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageCurCount() {
        return pageCurCount;
    }

    public void setPageCurCount(Integer pageCurCount) {
        this.pageCurCount = pageCurCount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getLimitSql() {
        return limitSql;
    }

    public void setLimitSql(String limitSql) {
        this.limitSql = limitSql;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
