package com.cosmos.updatecompanytomongodb.controller;

import com.cosmos.updatecompanytomongodb.pojo.Companies;
import com.cosmos.updatecompanytomongodb.pojo.Company;
import com.cosmos.updatecompanytomongodb.pojo.EnhancedCompanyDetailss;
import com.cosmos.updatecompanytomongodb.service.UpdateCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/updatecompany")
@Slf4j
public class UpdateCompanyController {
    @Autowired
    private UpdateCompanyService updateCompanyService;
    @PutMapping(value = "/{companyName}", consumes = "application/json", produces = "application/json")
    public Company updateCompanyDetails(@PathVariable String companyName, @RequestBody Company company){
        log.info("Got update call for "+company);
        return updateCompanyService.updateCompanyDetails(companyName,company);
    }
    @GetMapping
    public Companies getAllCompanies(){
        return updateCompanyService.getAllCompanies();
    }
    @GetMapping("/watchlistin/{companyWatchListIn}")
    public Companies getAllCompaniesBasedOnWatchList(@PathVariable String companyWatchListIn){
        log.info("Get List for watchList "+companyWatchListIn);
        return updateCompanyService.getAllCompaniesBasedOnWatchList(companyWatchListIn);
    }
    @GetMapping(value = "/enhancedwatchlistin/{companyWatchListIn}", produces = "application/json")
    public EnhancedCompanyDetailss getAllEnhancedCompaniesBasedOnWatchList(@PathVariable String companyWatchListIn){
        log.info("Get List for watchList  "+companyWatchListIn);
        EnhancedCompanyDetailss enhancedCompanyDetailss = updateCompanyService.getAllEnhancedCompaniesBasedOnWatchList(companyWatchListIn);
        //log.info("Response for watchList  "+enhancedCompanyDetailss);
        return enhancedCompanyDetailss;
    }

    @GetMapping("/{companyName}")
    public Company getCompanyByCompanyName(@PathVariable String companyName){
        return updateCompanyService.getCompanyByCompanyName(companyName);
    }
}
