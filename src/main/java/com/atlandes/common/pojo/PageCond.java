package com.atlandes.common.pojo;

import com.atlandes.admin.constant.DefaultPageConfig;

/**
 * Created by XD.Wang on 2017/6/13.
 * 分页信息
 */
public class PageCond {

    private int pageSize;

    private int pageCurCount;

    private int pageTotalCount;

    public static PageCond getDefaultPageCond(int pageCurCount, int pageTotalCount) {
        PageCond pageCond = new PageCond();
        pageCond.setPageSize(DefaultPageConfig.DEFAULT_PAGE_SIZE);
        pageCond.setPageCurCount(pageCurCount * DefaultPageConfig.DEFAULT_PAGE_SIZE);
        pageCond.setPageTotalCount(Math.round(pageTotalCount / DefaultPageConfig.DEFAULT_PAGE_SIZE) + 1);
        return pageCond;
    }

    public PageCond() {
        this.setPageCurCount(DefaultPageConfig.INIT_PAGE_COUNT);
        this.setPageSize(DefaultPageConfig.DEFAULT_PAGE_SIZE);
    }

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
