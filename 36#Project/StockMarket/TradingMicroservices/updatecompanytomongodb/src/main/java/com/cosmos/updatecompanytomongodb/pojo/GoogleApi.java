package com.cosmos.updatecompanytomongodb.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoogleApi {
    public ArrayList<CompanyDetails> data;
}
