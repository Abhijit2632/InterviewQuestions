package com.cosmos.service;

import com.cosmos.pojo.Companies;
import com.cosmos.pojo.Company;
import com.cosmos.pojo.CompanyWithStats;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WatchListService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    public Companies getAllCompaniesByHighestGrowthToday() {
        //getAllFallGoogleDataForToday();
        getAllGrowthGoogleDataForToday();
        return getAllFallGoogleDataForToday();
    }
    private Companies getAllGrowthGoogleDataForToday() {
        List<CompanyWithStats> companyWithStatsList = new ArrayList<>();
        List<Company> companyList = getAllGoogleData().getData();
        List<Company> growthList = companyList.stream()
                .filter(company -> {
                    Double ltp = company.getCompanyLTP();
                    Double prevClose = company.getCompanyPreviousClose();
                    Double percentage = 0.0;
                    if(ltp>prevClose){
                        Double gap = ltp - prevClose;
                        percentage = gap*100/ltp;
                    }
                    if(percentage>3){
                        //log.info("Company is :"+company.companyName+" and increased by : "+percentage);
                        CompanyWithStats companyWithStats = CompanyWithStats.builder()
                                .companyName(company.companyName)
                                .type("GROWTH")
                                .percentage(percentage)
                                .currentDate(LocalDate.now())
                                .build();
                        companyWithStatsList.add(companyWithStats);
                        return true;
                    }
                    else {
                        return false;
                    }
                })
                .collect(Collectors.toList());
        String path = "";
        path = LocalDate.now().getDayOfMonth()+"-"+LocalDate.now().getMonth()+"-GROWTH";
        saveCompanyStats(companyWithStatsList,path);
        return new Companies(growthList);
    }

    private Companies getAllFallGoogleDataForToday() {
        List<CompanyWithStats> companyWithStatsList = new ArrayList<>();
        List<Company> companyList = getAllGoogleData().getData();
        List<Company> growthList = companyList.stream()
                .filter(company -> {
                    Double ltp = company.getCompanyLTP();
                    Double prevClose = company.getCompanyPreviousClose();
                    Double percentage = 0.0;
                    if(ltp<prevClose){
                        Double gap = prevClose - ltp;
                        percentage = gap*100/ltp;
                    }
                    if(percentage>3){
                        //log.info("Company is :"+company.companyName+" and decreased by : "+percentage);
                        CompanyWithStats companyWithStats = CompanyWithStats.builder()
                                .companyName(company.companyName)
                                .type("FALL")
                                .percentage(percentage)
                                .currentDate(LocalDate.now())
                                .build();
                        companyWithStatsList.add(companyWithStats);
                        return true;
                    }
                    else {
                        return false;
                    }
                })
                .collect(Collectors.toList());
        String path = "";
        path = LocalDate.now().getDayOfMonth()+"-"+LocalDate.now().getMonth()+"-FALL";
        saveCompanyStats(companyWithStatsList,path);
        return new Companies(growthList);
    }

    private void saveCompanyStats(List<CompanyWithStats> companyWithStatsList,String name) {
        //ObjectMapper mapper = new ObjectMapper();
        String path = "/Users/abhijit4981/Desktop/InterviewDocs/StockMarket/TradingMicroservices/"+name+".txt";
        try {
            objectMapper.writeValue(new File(path), companyWithStatsList );
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("saved success.."+path);
    }

    private Companies getAllGoogleData() {
        String getUrl = "https://script.google.com/macros/s/AKfycbxy_NKbqJVdLx_6yDLHN9UhgQyk39GC-iKlR9PFxN1YSj7o6JxR1HUMcIYjnYMxSM3n/exec";
        String response = restTemplate.getForObject(getUrl,String.class);
        ObjectMapper mapper = new ObjectMapper();
        Companies googleApi = null;
        try {
            googleApi = mapper.readValue(response, Companies.class);
        } catch (JsonProcessingException e) {
            log.error("Not able to parse Json"+e.getMessage());
        }
        return googleApi;
    }
}
