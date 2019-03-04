package com.atlandes.erp.service;

import com.atlandes.erp.po.Price;

import java.util.List;

public interface PriceService {
    int insertPrice (Price price);

    Price selectPriceById(Integer id);

    List<Price> selectPriceList();

    int updatePriceById(Integer id);

    void deletePriceById(Integer id);
}
