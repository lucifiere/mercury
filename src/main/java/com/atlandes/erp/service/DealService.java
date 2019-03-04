package com.atlandes.erp.service;

import com.atlandes.erp.po.Deal;
import com.atlandes.erp.vo.DealVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DealService {
    int insertDeal(Deal deal);

    DealVO selectDealById(int id);

    List<DealVO> selectDealList();

    int updateDealById(Deal deal);

    void deleteDealById(int id);
}
