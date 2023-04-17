package com.cosmos.notesservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonConfig {
    /*@Bean
    public WebClient getWebClient(){
        *//*final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();*//*
        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(client ->
        client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                .doOnConnected(conn -> conn
                .addHandlerLast(new ReadTimeoutHandler(10))
                .addHandlerLast(new WriteTimeoutHandler(10))));

        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        WebClient webClient2 = WebClient.builder()
                .baseUrl("http://localhost:9191/")
                .clientConnector(connector)
                //.exchangeStrategies(strategies)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return webClient2;
    }*/
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
