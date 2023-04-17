package com.cosmos.updatecompanytomongodb.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WatchArray {
    @JsonProperty("IT_Longterm")
    public boolean iT_Longterm;
    @JsonProperty("IT_Growth")
    public boolean iT_Growth;
    @JsonProperty("Banking")
    public boolean banking;
    @JsonProperty("Private_Banks")
    public boolean private_Banks;
    @JsonProperty("Finance")
    public boolean finance;
    @JsonProperty("MutualFunds")
    public boolean mutualFunds;
    @JsonProperty("LTThan1000")
    public boolean lTThan1000;
    @JsonProperty("Popular")
    public boolean popular;
    @JsonProperty("Popular2")
    public boolean popular2;
    @JsonProperty("Monopoly")
    public boolean monopoly;
    @JsonProperty("Govt")
    public boolean govt;
    @JsonProperty("MayBe")
    public boolean mayBe;
    @JsonProperty("Radar")
    public boolean radar;
    @JsonProperty("Recommendation")
    public boolean recommendation;
    @JsonProperty("MustBuy")
    public boolean mustBuy;
    @JsonProperty("BigHouse")
    public boolean bigHouse;
    @JsonProperty("Adani")
    public boolean adani;
    @JsonProperty("Tata")
    public boolean tata;
    @JsonProperty("Mahindra")
    public boolean mahindra;
    @JsonProperty("Bajaj")
    public boolean bajaj;
    @JsonProperty("Electronics")
    public boolean electronics;
    @JsonProperty("Paints")
    public boolean paints;
    @JsonProperty("Cement")
    public boolean cement;
}
