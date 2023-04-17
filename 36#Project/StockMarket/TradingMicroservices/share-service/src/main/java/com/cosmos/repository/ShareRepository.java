package com.cosmos.repository;

import com.cosmos.model.Shareorder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShareRepository extends MongoRepository<Shareorder,String> {
    List<Shareorder> findShareorderByCompanyName(String companyName);
}
