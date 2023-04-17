package com.cosmos.readnseexceldata.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDetails {
    @JsonProperty("Name")
    public String name;
    @JsonProperty("LTP")
    public double lTP;
    @JsonProperty("Open")
    public double open;
    @JsonProperty("High")
    public double high;
    @JsonProperty("Low")
    public double low;
    @JsonProperty("Volume")
    public int volume;
    @JsonProperty("PREVClose")
    public double prevClose;
}
