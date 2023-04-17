package com.cosmos.repository;

import com.cosmos.document.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet ,Long> {
}
