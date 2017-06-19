package com.atlandes.admin.vo;

import com.atlandes.common.proxy.PageQueryProxy;
import com.atlandes.common.pojo.Pagination;

/**
 * Created by XD.Wang on 2017/6/9.
 * 菜单查询
 */
public class MenuQuery extends Pagination {

    public MenuQuery(PageQueryProxy service, int pageSize) {
        super(service, pageSize);
    }

    public MenuQuery(PageQueryProxy service) {
        super(service);
    }

}
