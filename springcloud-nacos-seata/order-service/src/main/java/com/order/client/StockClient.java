package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock-service")
public interface StockClient {

    @PostMapping("/insert")
    void insert(@RequestParam String code);

    @PostMapping("/update")
    void update(@RequestParam String code);

}
