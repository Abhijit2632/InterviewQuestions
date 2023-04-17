package com.cosmos.readnseexceldata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NSEExcelData {
    private String companyName;
    private Float companyLTP;
    private Float companyOpen;
    private Float companyHigh;
    private Float companyLow;
    private Float companyVolume;
    private Float companyPreviousClose;
}
