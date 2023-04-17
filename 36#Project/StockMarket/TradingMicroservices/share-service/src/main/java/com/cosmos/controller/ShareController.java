package com.cosmos.controller;

import com.cosmos.model.Shareorder;
import com.cosmos.pojo.Shareorders;
import com.cosmos.service.ShareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/share")
@Slf4j
public class ShareController {
    @Autowired
    private ShareService shareService;

    @PostMapping(value = "/buy", consumes = "application/json", produces = "application/json")
    public Shareorder buyShare(@RequestBody Shareorder shareorder) {
        return shareService.buyShare(shareorder);
    }
    @PostMapping(value = "/sell", consumes = "application/json", produces = "application/json")
    public Shareorder sellShare(@RequestBody Shareorder shareorder) {
        return shareService.sellShare(shareorder);
    }
    @GetMapping("/orders")
    public Shareorders getAllOrders(){
        return shareService.getAllOrders();
    }

}