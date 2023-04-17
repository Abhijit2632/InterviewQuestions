package com.cosmos.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "companiesEveryThreeMinutes003")
public class CompaniesEveryThreeMinutes {
    @Id
    private String CompaniesEveryThreeMinutesId;
    private String data;
    private LocalDateTime takenTime;
}
