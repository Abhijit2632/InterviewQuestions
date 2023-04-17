package com.cosmos.cron;

import com.cosmos.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

@Configuration
@EnableScheduling
public class InGeneralCron {
    private String bootstrap_server_config_name = "localhost:9092";
    private String outputTopic = "flinkNSELiveTopic27Oct";
    @Autowired
    private CronService cronService;
    //@Scheduled(fixedRate = 15*60*1000)
    @Scheduled(fixedRate = 1*60*1000)
    public void scheduleFixedRateTask() {
        System.out.println(
                "Fixed rate task for every 3 seconds - " + System.currentTimeMillis());
        String message = cronService.getAllGoogleData();
        cronService.sendMessageToKafka(message ,outputTopic);
    }
    //@Scheduled(cron = "*/3 0 9 * * 1-5")
    public void scheduleFixedCronTaskForNSETimings() {
        System.out.println(
                "Cron task after 9 task - " + System.currentTimeMillis());
    }

}
