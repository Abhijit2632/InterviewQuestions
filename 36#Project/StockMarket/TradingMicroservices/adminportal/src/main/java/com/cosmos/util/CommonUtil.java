package com.cosmos.util;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.cosmos.document.WalletTxSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CommonUtil {
    @Autowired
    private MongoOperations mongoOperations;

    public long generateSequence(String seqName) {
        WalletTxSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                WalletTxSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
