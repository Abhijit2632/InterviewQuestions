package com.cosmos.FlinkIntelijIdea.schema;

import com.cosmos.FlinkIntelijIdea.pojo.CompanyDetailsList;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.java.tuple.Tuple2;

import java.nio.charset.StandardCharsets;

public class Tuple2ProducerSerializationSchema implements SerializationSchema<Tuple2<String, CompanyDetailsList>> {

    @Override
    public byte[] serialize(Tuple2<String, CompanyDetailsList> stringCompanyDetailsListTuple2) {
        CompanyDetailsList companyDetailsList = stringCompanyDetailsListTuple2.f1;
        return companyDetailsList.toString().getBytes(StandardCharsets.UTF_8);
    }
}
