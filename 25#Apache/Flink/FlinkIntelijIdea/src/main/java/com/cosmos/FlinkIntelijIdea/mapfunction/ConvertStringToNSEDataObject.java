package com.cosmos.FlinkIntelijIdea.mapfunction;

import com.cosmos.FlinkIntelijIdea.pojo.CompanyDetails;
import com.cosmos.FlinkIntelijIdea.pojo.CompanyDetailsList;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.type.TypeReference;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@Slf4j
public class ConvertStringToNSEDataObject implements MapFunction<String, Tuple2<String,CompanyDetailsList>> {
    private static int count = 0;
    @Override
    public Tuple2<String,CompanyDetailsList>  map(String response) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<CompanyDetails> companyDetailsList = null;
        try {
            companyDetailsList = mapper.readValue(response, new TypeReference<List<CompanyDetails>>(){});
            log.info("Got Response : "+companyDetailsList.size());
            count++;
        } catch (JsonProcessingException e) {
            log.error("Not able to parse Json");
        }
        Tuple2<String,CompanyDetailsList> tuple2 = new Tuple2("FlinkJob:"+count,companyDetailsList);
        return tuple2;
    }
}
