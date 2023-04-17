package com.cosmos.controller;

import com.cosmos.pojo.Companies;
import com.cosmos.service.WatchListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watchlist")
@Slf4j
public class WatchListController {
    @Autowired
    private WatchListService watchListService;

    @GetMapping("/growth")
    public Companies getAllCompaniesByHighestGrowthToday(){
        return watchListService.getAllCompaniesByHighestGrowthToday();
    }
}
