package com.cosmos.FlinkIntelijIdea.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CompanyDetails {
    @JsonProperty("companyName")
    public String name;
    @JsonProperty("companyLTP")
    public double lTP;
    @JsonProperty("companyOpen")
    public double open;
    @JsonProperty("companyHigh")
    public double high;
    @JsonProperty("companyLow")
    public double low;
    @JsonProperty("companyVolume")
    public int volume;
    @JsonProperty("companyPreviousClose")
    public double prevClose;
}
