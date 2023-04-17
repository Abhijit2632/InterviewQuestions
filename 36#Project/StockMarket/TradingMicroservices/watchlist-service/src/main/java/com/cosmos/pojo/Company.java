package com.cosmos.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Company {
    @JsonProperty("companyName")
    public String companyName;
    @JsonProperty("companyLTP")
    public double companyLTP;
    @JsonProperty("companyOpen")
    public double companyOpen;
    @JsonProperty("companyHigh")
    public double companyHigh;
    @JsonProperty("companyLow")
    public double companyLow;
    @JsonProperty("companyVolume")
    public int companyVolume;
    @JsonProperty("companyPreviousClose")
    public double companyPreviousClose;

}
