package com.cosmos.FlinkIntelijIdea.stream.second;

import com.cosmos.FlinkIntelijIdea.mapfunction.ConvertStringToNSEDataObject;
import com.cosmos.FlinkIntelijIdea.pojo.CompanyDetailsList;
import com.cosmos.FlinkIntelijIdea.schema.Tuple2ProducerSerializationSchema;
import com.cosmos.FlinkIntelijIdea.stream.first.WordsCapitalizer;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

@Slf4j
public class NseKafkaTest {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        String inputTopic = "flinkNSELiveTopic27Oct";
        String outputTopic = "flinkNSELiveTopic27OctTestOutput";
        String consumerGroup = "NSE-Live-Data-From-Google-Sheets";
        String address = "localhost:9092";

        KafkaSource<String> source = KafkaSource.<String>builder()
                .setBootstrapServers(address)
                .setTopics(inputTopic)
                .setGroupId(consumerGroup)
                .setStartingOffsets(OffsetsInitializer.latest())
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();
        final ParameterTool params = ParameterTool.fromArgs(args);
        env.getConfig().setGlobalJobParameters(params);
        env.setParallelism(1);

        DataStream<String> stringInputStream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka Source");

        //Ur Code Starts here
        KafkaSink<String> sink = KafkaSink.<String>builder()
                .setBootstrapServers(address)
                .setRecordSerializer(KafkaRecordSerializationSchema.builder()
                        .setTopic(outputTopic)
                        .setValueSerializationSchema(new SimpleStringSchema())
                        .build()
                )
                //.setDeliveryGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .build();
        log.info("Successfully processed one set of records.");

        DataStream<Tuple2<String, CompanyDetailsList>> tuple2 = stringInputStream.map(new ConvertStringToNSEDataObject());

        KafkaSink<Tuple2<String, CompanyDetailsList>> tuple2KafkaSink = KafkaSink.<Tuple2<String, CompanyDetailsList>>builder()
                .setBootstrapServers(address)
                .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .setTransactionalIdPrefix("my-trx-id-prefix")
                .setRecordSerializer(KafkaRecordSerializationSchema.builder().setTopic(outputTopic)
                        .setValueSerializationSchema(new Tuple2ProducerSerializationSchema()).build())
                .build();

        tuple2.sinkTo(tuple2KafkaSink).name("Kafka: " + outputTopic)
                .uid("enrichedTradeSource");

        /*DataStream<String> stringInputStreamAgain = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka Source");

        DataStream<String> filtered = stringInputStreamAgain.filter((val)->val.startsWith("A"));

        DataSet<Tuple2<String,Integer>> token = filtered.map(new TokenizerMapFunction()).keyBy(0).sum(0).sinkTo(sink);
*/
        env.execute();
    }
}
