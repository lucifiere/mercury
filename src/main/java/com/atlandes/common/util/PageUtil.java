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

    public PageUtil(PaginationQueryService<R> service) {
        this.service = service;
    }

    public Pagination<R> getRowList(Pagination pageCond) {
        return this.service.getList4Page(pageCond);
    }

    public static <R> Pagination<R> getPagingList(PaginationQueryService<R> service, Pagination page) {
        PageUtil<R> pagination = new PageUtil<>(service);
        page.setPageSize(page.getPageSize() != null ? page.getPageSize() : DefaultPageConfig.DEFAULT_PAGE_SIZE);
        int curr = page.getPageCurCount() != null ? page.getPageCurCount() : 1;
        page.setOffset((curr - 1) * page.getPageSize());
        return pagination.getRowList(page);
    }

}
