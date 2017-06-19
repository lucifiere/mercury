package com.atlandes.common.proxy;

import com.atlandes.common.pojo.Pagination;

import java.util.Collection;

/**
 * Created by XD.Wang on 2017/6/19.
 * 分页Service代理
 */
public interface PageQueryProxy<R> {

    Collection<R> queryList(Pagination var1);

}
