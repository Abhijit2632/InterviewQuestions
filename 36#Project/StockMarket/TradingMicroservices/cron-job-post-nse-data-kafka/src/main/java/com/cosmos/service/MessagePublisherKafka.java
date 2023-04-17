package com.cosmos.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
@Slf4j
public class MessagePublisherKafka {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(String message, String topic, String key) throws Exception {
        log.info("entering sendMessage for this : "+key);
        try {
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, key, message);
            future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                @Override
                public void onSuccess(SendResult<String, Object> result) {
                    log.info("Message Successfully delivered... ");
                }

                @Override
                public void onFailure(Throwable ex) {
                    log.info("Exception occurred while transferring message : "+ex.getMessage());
                }
            });
        } catch (Exception e) {
            log.error("Kafka send message error , "+e.getMessage());
        }
    }



}
