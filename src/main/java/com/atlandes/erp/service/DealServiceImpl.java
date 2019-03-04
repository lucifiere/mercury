package com.atlandes.erp.service;

import com.atlandes.erp.dao.DealMapper;
import com.atlandes.erp.po.Deal;
import com.atlandes.erp.vo.DealVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    @Resource
    private DealMapper dealMapper;

    @Override
    public int insertDeal(Deal deal) {
        return dealMapper.insertDeal(deal);
    }

    @Override
    public DealVO selectDealById(int id) {
        return dealMapper.selectDealById(id);
    }

    @Override
    public List<DealVO> selectDealList() {
        return dealMapper.selectDealList();
    }

    @Override
    public int updateDealById(Deal deal) {
        return dealMapper.updateDealById(deal);
    }

    @Override
    public void deleteDealById(int id) {
        dealMapper.deleteDealById(id);
    }
}
