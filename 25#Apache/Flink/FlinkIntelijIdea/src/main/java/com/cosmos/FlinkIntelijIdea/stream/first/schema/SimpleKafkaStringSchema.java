package com.cosmos.FlinkIntelijIdea.stream.first.schema;

import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.java.tuple.Tuple2;

public class SimpleKafkaStringSchema implements SerializationSchema<Tuple2<String,Integer>> {
    @Override
    public byte[] serialize(Tuple2<String, Integer> element) {
        return new byte[0];
    }
}
