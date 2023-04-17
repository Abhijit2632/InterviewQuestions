package com.cosmos.repository;

import com.cosmos.pojo.CompaniesEveryThreeMinutes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompaniesEveryThreeMinutesRepository extends MongoRepository<CompaniesEveryThreeMinutes,String> {
}
