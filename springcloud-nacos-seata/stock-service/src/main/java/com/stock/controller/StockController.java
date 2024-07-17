package com.stock.controller;

import com.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired StockService stockServices;

    @PostMapping(path = "/insert")
    public void insert(String code) {
        stockServices.insert(code);
    }

    @PostMapping(path = "/update")
    public void update(String code) {
        stockServices.update(code);
    }
}
