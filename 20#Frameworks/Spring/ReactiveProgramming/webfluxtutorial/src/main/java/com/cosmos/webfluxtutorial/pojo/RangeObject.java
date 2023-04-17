package com.cosmos.webfluxtutorial.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RangeObject {
    private Float startValue;
    private Float endValue;
}
