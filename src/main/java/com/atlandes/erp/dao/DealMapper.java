package com.atlandes.erp.dao;

import com.atlandes.erp.po.Deal;
import com.atlandes.erp.vo.DealVO;

import java.util.List;

public interface DealMapper {

    int insertDeal(Deal deal);

    DealVO selectDealById(int id);

    List<DealVO> selectDealList();

    int updateDealById(Deal deal);

    void deleteDealById(int id);
}
