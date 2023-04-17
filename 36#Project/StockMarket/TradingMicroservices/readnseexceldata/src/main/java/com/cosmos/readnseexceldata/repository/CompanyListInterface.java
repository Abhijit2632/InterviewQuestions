package com.cosmos.readnseexceldata.repository;

import com.cosmos.readnseexceldata.document.CompanyList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyListInterface extends MongoRepository<CompanyList,String> {
}
