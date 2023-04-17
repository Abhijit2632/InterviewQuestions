package com.cosmos.webfluxtutorial.controller;

import com.cosmos.webfluxtutorial.pojo.NSEExcelData;
import com.cosmos.webfluxtutorial.pojo.RangeObject;
import com.cosmos.webfluxtutorial.util.RangeNseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/googleapi")
public class GoogleApiController {
    @Autowired
    private RangeNseData rangeNseData;

    @GetMapping("/betweentenandthirty")
    public Flux<List<NSEExcelData>> getAllApiDate(){
        return rangeNseData.getDataBetweenTenAndThirty();
    }
    @GetMapping("/between")
    public Flux<List<NSEExcelData>> getAllApiDataBetween(@RequestBody RangeObject rangeObject){
        return rangeNseData.getDataBetweenRange(rangeObject.getStartValue(),rangeObject.getEndValue());
    }
}
