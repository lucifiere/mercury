package com.atlandes.common.util;

import com.atlandes.common.constant.DefaultPageConfig;
import com.atlandes.common.pojo.Pagination;
import com.atlandes.common.proxy.PageQueryProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Created by XD.Wang on 2017/6/19.
 */
public class PageUtil<R> {

    private static final Logger LOG = LoggerFactory.getLogger(Pagination.class);

    private PageQueryProxy<R> service;

    public Pagination(PageQueryProxy<R> service, int pageSize) {
        this.service = service;
        this.pageSize = pageSize;
    }

    public Pagination(PageQueryProxy<R> service) {
        this(service, DefaultPageConfig.DEFAULT_PAGE_SIZE);
    }


    public Collection<R> getRowList(Pagination pageCond) {
        return this.service.queryList(pageCond);
    }

    public static <R> Collection<R> getPaginList(Pagination par, PageQueryProxy<R> service) {
        Pagination<R> pagination = new Pagination<>(service);
        String sql = String.format(" limit %d,%d ", par.getPageCurCount(), pagination.getPageSize());
        par.setLimitSql(sql);
        int curr = par.getPageCurCount() != null ? par.getPageCurCount() : 1;
        par.setOffset((curr - 1) * pagination.pageSize);
        return pagination.getRowList(par);
    }

}
