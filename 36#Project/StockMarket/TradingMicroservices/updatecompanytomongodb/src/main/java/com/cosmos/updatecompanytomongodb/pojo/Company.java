package com.cosmos.updatecompanytomongodb.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "company003")
public class Company {
    @Id
    private String companyName;
    private String companyTrendPattern;
    private int companyDaysAsNumbers;
    private String  companyCapSize;
    private String companyWatchlist;
    private int companyPosition;
    //private WatchArray watchArray;
}
