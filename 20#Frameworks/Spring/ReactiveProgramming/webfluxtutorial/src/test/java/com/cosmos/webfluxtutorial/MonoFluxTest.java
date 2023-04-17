package com.cosmos.webfluxtutorial;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
    @Test
    public void monoTest(){
        //Create the object of Publisher
        Mono<String> monoString = Mono.just("Hi Abhijit").log();
        //call for subscribe() using publisher object
        monoString.subscribe(System.out::println);
    }
    @Test
    public void fluxTest(){
        //Create the object of Publisher
        Flux<String> fluxString = Flux.just("Spring","Hibernate","Rest API","Microservices")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Reading string value got exception")))
                .concatWithValues("Azure")
                .log();
        //call for subscribe() using publisher object
        fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
}
