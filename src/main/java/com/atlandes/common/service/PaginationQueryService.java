package com.atlandes.common.service;

import com.atlandes.common.pojo.Pagination;

/**
 * Created by XD.Wang on 2017/6/19.
 * 分页Service代理
 */
public interface PaginationQueryService<R> {

    Pagination<R> getList4Page(Pagination var1);

}
