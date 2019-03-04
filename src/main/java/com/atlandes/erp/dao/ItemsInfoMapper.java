package com.atlandes.erp.dao;

import com.atlandes.erp.po.ItemsInfo;
import com.atlandes.erp.vo.ItemsInfoVO;
import sun.rmi.server.InactiveGroupException;

import java.util.List;

public interface ItemsInfoMapper {

    Integer insertItemsInfo(ItemsInfo itemsInfo);

    ItemsInfoVO selectItemsInfoById(Integer id);

    List<ItemsInfoVO> selectItemsInfoList();

    Integer updateItemsInfo(ItemsInfo itemsInfo);

    void deleteItemsInfoById(Integer id);
}
