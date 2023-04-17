package com.cosmos.updatecompanytomongodb.service;

import com.cosmos.updatecompanytomongodb.pojo.*;
import com.cosmos.updatecompanytomongodb.repository.UpdateCompanyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UpdateCompanyService {
    @Autowired
    private UpdateCompanyRepository updateCompanyRepository;
    @Autowired
    private RestTemplate restTemplate;
    public Company updateCompanyDetails(String companyName, Company company) {
        company.setCompanyName(companyName);
        Company company1 = updateCompanyRepository.save(company);
        log.info("updated this company "+company1);
        return company1;
    }


    public Companies getAllCompanies() {
        List<Company> companyList = updateCompanyRepository.findAll();
        return new Companies(companyList);
    }

    public Company getCompanyByCompanyName(String companyName) {
        Optional<Company> companyOptional = updateCompanyRepository.findById(companyName);
        if(companyOptional.isPresent()){
            return companyOptional.get();
        }else{
            return new Company();
        }
    }

    public EnhancedCompanyDetailss getAllEnhancedCompaniesBasedOnWatchList(String companyWatchlist){
        List<Company> companyList = updateCompanyRepository.findByCompanyWatchlist(companyWatchlist);
        GoogleApi googleApi = getAllGoogleData();
        List<EnhancedCompanyDetails> listCommon2 = companyList.stream()
                .flatMap(one -> googleApi.data.stream()
                        .filter(two -> one.getCompanyName().equalsIgnoreCase(two.getName()))
                        .map(two -> new EnhancedCompanyDetails(one , two)))
                .collect(Collectors.toList());
        log.info("Common Data found--------------------3 "+listCommon2);
        return new EnhancedCompanyDetailss(listCommon2);
    }

    public Companies getAllCompaniesBasedOnWatchList(String companyWatchlist) {
        List<Company> companyList = updateCompanyRepository.findByCompanyWatchlist(companyWatchlist);
        log.info("Data found "+companyList);

        //read from google api and Try 1
        /*GoogleApi googleApi = getAllGoogleData();
        List<Company> listCommon =companyList.stream()
                .filter(obj->googleApi.getData().stream()
                        .anyMatch(one -> one.getName().equalsIgnoreCase(obj.getCompanyName())))
                .collect(Collectors.toList());
        log.info("Common Data found--------------------1 "+listCommon);*/
        //Try 2
        /*GoogleApi googleApi = getAllGoogleData();
        List<CompanyDetails> listCommon1 =googleApi.getData().stream()
                .filter(obj->companyList.stream()
                        .anyMatch(one -> one.getCompanyName().equalsIgnoreCase(obj.name)))
                .collect(Collectors.toList());
        log.info("Common Data found--------------------2 "+listCommon1);*/

        return new Companies(companyList);
    }
    public GoogleApi getAllGoogleData() {
        String getUrl = "https://script.google.com/macros/s/AKfycbyzsJfnIcnSMsiDAPYYZ9MpKoKop6slci5CdyudOfSTZOUREAMCl1ctg_XbyvsHte0o/exec";
        String response = restTemplate.getForObject(getUrl,String.class);
        ObjectMapper mapper = new ObjectMapper();
        GoogleApi googleApi = null;
        try {
            googleApi = mapper.readValue(response, GoogleApi.class);
            log.info("Got Response : "+googleApi);
        } catch (JsonProcessingException e) {
            log.error("Not able to parse Json");
        }
        return googleApi;
    }
}
