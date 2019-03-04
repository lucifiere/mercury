package com.atlandes.erp.service;

import com.atlandes.erp.po.ItemsInfo;
import com.atlandes.erp.vo.ItemsInfoVO;

import java.util.List;

public interface ItemsInfoService {
    Integer insertItemsInfo(ItemsInfo itemsInfo);

    ItemsInfoVO selectItemsInfoById(Integer id);

    List<ItemsInfoVO> selectItemsInfoList();

    Integer updateItemsInfo(ItemsInfo itemsInfo);

    void deleteItemsInfoById(Integer id);
}
