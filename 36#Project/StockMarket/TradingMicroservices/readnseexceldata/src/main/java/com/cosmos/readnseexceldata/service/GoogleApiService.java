package com.cosmos.readnseexceldata.service;

import com.cosmos.readnseexceldata.document.CompanyList;
import com.cosmos.readnseexceldata.pojo.CompanyDetails;
import com.cosmos.readnseexceldata.pojo.GoogleApi;
import com.cosmos.readnseexceldata.repository.CompanyListInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GoogleApiService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CompanyListInterface repository;
    public void getAllGoogleDataLessThan1000() {
        String getUrl = "https://script.google.com/macros/s/AKfycbyzsJfnIcnSMsiDAPYYZ9MpKoKop6slci5CdyudOfSTZOUREAMCl1ctg_XbyvsHte0o/exec";
        String response = restTemplate.getForObject(getUrl,String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            GoogleApi googleApi = mapper.readValue(response, GoogleApi.class);
            log.info("Got Response : "+googleApi);
            segregatePositiveAndNegetiveOnes(googleApi);
        } catch (JsonProcessingException e) {
            log.error("Not able to parse Json");
        }
    }

    private void segregatePositiveAndNegetiveOnes(GoogleApi googleApi) {
        List<CompanyDetails> companyDetailsList = googleApi.getData();
        List<CompanyDetails> positiveList = companyDetailsList.stream()
                .filter(p->p.getLTP()>p.getPrevClose())
                .collect(Collectors.toList());
        List<CompanyDetails> negetiveList = companyDetailsList.stream()
                .filter(p->p.getLTP()<=p.getPrevClose())
                .collect(Collectors.toList());
        CompanyList companyListPositive = new CompanyList();
        LocalDate today = LocalDate.now();
        companyListPositive.setCompanyListName("PositiveList"+today.getDayOfMonth()+"-"+today.getMonthValue());
        companyListPositive.setCompanyListTakenTime(LocalDate.now());
        companyListPositive.setCompanyDetailsList(positiveList);
        repository.save(companyListPositive);

        CompanyList companyListNegetive = new CompanyList();
        companyListNegetive.setCompanyListName("NegetiveList"+today.getDayOfMonth()+"-"+today.getMonthValue());
        companyListNegetive.setCompanyListTakenTime(LocalDate.now());
        companyListNegetive.setCompanyDetailsList(negetiveList);
        repository.save(companyListNegetive);
    }
}
