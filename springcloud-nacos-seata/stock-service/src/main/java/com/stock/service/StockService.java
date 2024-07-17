package com.stock.service;

import com.stock.entity.Stock;
import com.stock.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {
    @Autowired StockMapper stockMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insert(String code) {
        Stock stock = new Stock();
        stock.setCode(code);
        stock.setCount(0);
        stockMapper.insert(stock);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(String code) {
        Stock stock = new Stock();
        stock.setCode(code);
        stock.setCount(1);
        stockMapper.updateById(stock);
    }
}
