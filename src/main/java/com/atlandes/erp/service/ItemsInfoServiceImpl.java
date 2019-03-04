package com.atlandes.erp.service;

import com.atlandes.erp.dao.ItemsInfoMapper;
import com.atlandes.erp.po.ItemsInfo;
import com.atlandes.erp.vo.ItemsInfoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemsInfoServiceImpl implements ItemsInfoService {

    @Resource
    ItemsInfoMapper itemsInfoMapper;

    @Override
    public Integer insertItemsInfo(ItemsInfo itemsInfo) {
        return itemsInfoMapper.insertItemsInfo(itemsInfo);
    }

    @Override
    public ItemsInfoVO selectItemsInfoById(Integer id) {
        return itemsInfoMapper.selectItemsInfoById(id);
    }

    @Override
    public List<ItemsInfoVO> selectItemsInfoList() {
        return itemsInfoMapper.selectItemsInfoList();
    }

    @Override
    public Integer updateItemsInfo(ItemsInfo itemsInfo) {
        return itemsInfoMapper.updateItemsInfo(itemsInfo);
    }

    @Override
    public void deleteItemsInfoById(Integer id) {
        itemsInfoMapper.deleteItemsInfoById(id);
    }
}
