package com.cosmos.webfluxtutorial.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NSEExcelData {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String companyName;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String companyLTP;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String companyOpen;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String companyHigh;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String companyLow;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String companyVolume;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String companyPreviousClose;
}
