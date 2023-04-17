package com.cosmos.updatecompanytomongodb.repository;

import com.cosmos.updatecompanytomongodb.pojo.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UpdateCompanyRepository extends MongoRepository<Company,String> {
    List<Company> findByCompanyWatchlist(String companyWatchlist);
}
