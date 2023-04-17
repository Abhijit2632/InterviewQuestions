package com.cosmos.updatecompanytomongodb.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnhancedCompanyDetails {
    private Company company;
    private CompanyDetails companyDetails;
}
