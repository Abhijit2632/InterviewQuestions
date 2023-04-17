package com.cosmos;

import com.cosmos.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CronJobPostNseDataKafkaApplication {
		//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CronJobPostNseDataKafkaApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		cronService.sendMessageToKafka("Hi Abhijit","flinkTestDataStreamsOutputTopic");
	}*/

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
