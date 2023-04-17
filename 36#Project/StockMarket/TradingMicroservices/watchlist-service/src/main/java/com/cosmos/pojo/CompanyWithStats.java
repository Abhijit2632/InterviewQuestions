package com.cosmos.pojo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class CompanyWithStats {
    private String companyName;
    private String type;
    private Double percentage;
    private LocalDate currentDate;
}
