package com.atlandes.erp.service;

import com.atlandes.erp.dao.PriceMapper;
import com.atlandes.erp.po.Price;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Resource
    private PriceMapper priceMapper;

    @Override
    public int insertPrice(Price price) {
        return priceMapper.insertPrice(price);
    }

    @Override
    public Price selectPriceById(Integer id) {
        return priceMapper.selectPriceById(id);
    }

    @Override
    public List<Price> selectPriceList() {
        return priceMapper.selectPriceList();
    }

    @Override
    public int updatePriceById(Integer id) {
        return priceMapper.updatePriceById(id);
    }

    @Override
    public void deletePriceById(Integer id) {
        priceMapper.deletePriceById(id);
    }
}
