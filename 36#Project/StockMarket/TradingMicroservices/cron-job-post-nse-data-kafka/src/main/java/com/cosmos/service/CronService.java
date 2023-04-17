package com.cosmos.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Random;

@Service
@Slf4j
public class CronService {
    @Autowired
    private MessagePublisherKafka messagePublisherKafka;
    @Autowired
    private RestTemplate restTemplate;

    public void sendMessageToKafka(String message,String topicName){
        String trackingId = generateTrackingId();
        try {
            messagePublisherKafka.sendMessage(message,topicName,trackingId);
        } catch (Exception e) {
            log.error("Some error saving message to Kafka topic :"+e.getMessage());
        }
    }

    private String generateTrackingId() {
        int randomInt = new Random().nextInt(99999);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String trackingId = "";
        trackingId = "NseLiveData-"+timestamp.getTime()+"-"+randomInt;
        return trackingId;
    }
    public String getAllGoogleData() {
        String getUrl =
                //"https://script.google.com/macros/s/AKfycbyzsJfnIcnSMsiDAPYYZ9MpKoKop6slci5CdyudOfSTZOUREAMCl1ctg_XbyvsHte0o/exec";
        "https://script.google.com/macros/s/AKfycbxy_NKbqJVdLx_6yDLHN9UhgQyk39GC-iKlR9PFxN1YSj7o6JxR1HUMcIYjnYMxSM3n/exec";
        String response = restTemplate.getForObject(getUrl,String.class);
        return response;
    }
}
