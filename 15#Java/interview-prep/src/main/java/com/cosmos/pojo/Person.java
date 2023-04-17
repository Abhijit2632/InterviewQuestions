package com.cosmos.pojo;

import org.springframework.stereotype.Component;

@Component
public class Person {
    String str = "Abhijit";

    public String getName(){
        return str;
    }
}
