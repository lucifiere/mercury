package com.atlandes.common.pojo;

/**
 * Created by XD.Wang on 2017/6/13.
 * 分页信息
 */
public class PageCond {

    private int pageSize;

    private int pageCurCount;

    private int pageTotalCount;

    public int getPageCurCount() {
        return pageCurCount;
    }

    public void setPageCurCount(int pageCurCount) {
        this.pageCurCount = pageCurCount;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(int pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
