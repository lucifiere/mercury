package com.atlandes.common.util;

import com.atlandes.common.constant.DefaultPageConfig;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.proxy.PageQueryProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Created by XD.Wang on 2017/6/19.
 * 分页工具
 */
public class PageUtil<R> {

    private static final Logger LOG = LoggerFactory.getLogger(Pagination.class);

    private PageQueryProxy<R> service;

    public PageUtil(PageQueryProxy<R> service) {
        this.service = service;
    }

    public Pagination<R> getRowList(Pagination pageCond) {
        return this.service.getList4Page(pageCond);
    }

    public static <R> Pagination<R> getPagingList(PageQueryProxy<R> service, Pagination page) {
        PageUtil<R> pagination = new PageUtil<>(service);
        page.setPageSize(page.getPageSize() != null ? page.getPageSize() : DefaultPageConfig.DEFAULT_PAGE_SIZE);
        int curr = page.getPageCurCount() != null ? page.getPageCurCount() : 1;
        page.setOffset((curr - 1) * page.getPageSize());
        return pagination.getRowList(page);
    }

}
