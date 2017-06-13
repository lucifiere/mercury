package com.atlandes.admin.vo;

import com.atlandes.admin.constant.DefaultPageConfig;
import com.atlandes.common.pojo.PageCond;

/**
 * Created by XD.Wang on 2017/6/9.
 * 菜单查询
 */
public class MenuQuery extends PageCond {

    public MenuQuery() {
        super();
        this.setPageCurCount(DefaultPageConfig.INIT_PAGE_COUNT);
        this.setPageSize(DefaultPageConfig.DEFAULT_PAGE_SIZE);
    }

}
