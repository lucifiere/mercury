package com.atlandes.erp.dao;

import com.atlandes.erp.po.Price;

import java.util.List;

public interface PriceMapper {
    int insertPrice (Price price);

    Price selectPriceById(Integer id);

    List<Price> selectPriceList();

    int updatePriceById(Integer id);

    void deletePriceById(Integer id);
}
