package com.cosmos.FlinkIntelijIdea.first;

import com.cosmos.FlinkIntelijIdea.TokenizerMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.tuple.Tuple2;

public class CountOcuranceInFile {
    public static DataSet<Tuple2<String, Integer>> getCounts(DataSet<String> text) {
        DataSet<String> filtered = text.filter((val)->val.startsWith("A"));
        //convert String to Tuple using MapFunction
        DataSet<Tuple2<String,Integer>> token = filtered.map(new TokenizerMapFunction());

        return token.groupBy(0).sum(1);
    }
}
