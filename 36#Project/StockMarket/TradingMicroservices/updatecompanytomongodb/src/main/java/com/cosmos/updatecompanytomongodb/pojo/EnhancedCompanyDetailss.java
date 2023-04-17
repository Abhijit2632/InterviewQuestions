package com.cosmos.updatecompanytomongodb.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnhancedCompanyDetailss {
    private List<EnhancedCompanyDetails> enhancedCompanyDetailsList;
}
