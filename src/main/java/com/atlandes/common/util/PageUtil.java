package com.atlandes.common.util;

import com.atlandes.common.constant.DefaultPageConfig;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.service.PaginationQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by XD.Wang on 2017/6/19.
 * 分页工具
 */
public class PageUtil<R> {

    private static final Logger LOG = LoggerFactory.getLogger(Pagination.class);

    private PaginationQueryService<R> service;

    private PageUtil(PaginationQueryService<R> service) {
        this.service = service;
    }

    private Pagination<R> getRowList(Pagination pageCond) {
        return this.service.getList4Page(pageCond);
    }

    public static <R> Pagination<R> getPagingList(PaginationQueryService<R> service, Pagination page) {
        PageUtil<R> pagination = new PageUtil<>(service);
        int curr = page.getPageCurCount() != null ? page.getPageCurCount() : 1;
        page.setPageSize(page.getPageSize() != null ? page.getPageSize() : DefaultPageConfig.DEFAULT_PAGE_SIZE);
        page.setPageCurCount(curr);
        page.setOffset((curr - 1) * page.getPageSize());
        return pagination.getRowList(page);
    }

    public static <R> Pagination<R> getPagingList(PaginationQueryService<R> service, Integer currPageCount, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageCurCount(currPageCount);
        page.setPageSize(pageSize);
        return getPagingList(service, page);
    }

    public static <R> Pagination<R> getPagingList(PaginationQueryService<R> service, Integer currPageCount) {
        Pagination page = new Pagination();
        page.setPageCurCount(currPageCount);
        return getPagingList(service, page);
    }

}
