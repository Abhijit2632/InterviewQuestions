package com.cosmos.webfluxtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WebfluxtutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxtutorialApplication.class, args);
	}
	@Bean
	public WebClient.Builder getWebclient(){
		return WebClient.builder();
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
