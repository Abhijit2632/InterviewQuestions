package com.cosmos.readnseexceldata.controller;

import com.cosmos.readnseexceldata.pojo.NSEExcelDatas;
import com.cosmos.readnseexceldata.service.GoogleApiService;
import com.cosmos.readnseexceldata.service.NseExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readexceldata")
public class ReadExcelDataController {
    @Autowired
    private NseExcelService nseExcelService;
    @Autowired
    private GoogleApiService googleApiService;
    @GetMapping("/date/{ondate}")
    public NSEExcelDatas getAllNSEDataForDate(@PathVariable String ondate){
        NSEExcelDatas nseExcelDatas = nseExcelService.readExcelFileData(ondate);
        return nseExcelDatas;
    }
    @GetMapping("/google/lessthan1000")
    public void getAllGoogleDataLessThan1000(){
        googleApiService.getAllGoogleDataLessThan1000();
    }
}
