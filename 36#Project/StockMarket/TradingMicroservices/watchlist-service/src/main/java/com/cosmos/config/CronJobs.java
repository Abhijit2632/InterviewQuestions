package com.cosmos.config;

import com.cosmos.pojo.CompaniesEveryThreeMinutes;
import com.cosmos.repository.CompaniesEveryThreeMinutesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableScheduling
@Slf4j
public class CronJobs {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CompaniesEveryThreeMinutesRepository companiesEveryThreeMinutesRepository;

    @Scheduled(fixedDelay = 3000*60)
    public void scheduleFixedDelayTask() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        log.info("Executed time"+ dtf.format(now));

        //Run's every 3 minutes to read google data and saves it to Mongodb

        String getUrl = "https://script.google.com/macros/s/AKfycbxy_NKbqJVdLx_6yDLHN9UhgQyk39GC-iKlR9PFxN1YSj7o6JxR1HUMcIYjnYMxSM3n/exec";
        String response = restTemplate.getForObject(getUrl,String.class);
        CompaniesEveryThreeMinutes companiesEveryThreeMinutes = CompaniesEveryThreeMinutes.builder()
                .data(response)
                .takenTime(LocalDateTime.now()).build();
        companiesEveryThreeMinutesRepository.save(companiesEveryThreeMinutes);
        log.info("Executed time to save a new record : "+ dtf.format(now));
    }

    @Scheduled(cron = "0 15 10 15 * ?")
    public void scheduleTaskUsingCronExpression() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }
}
