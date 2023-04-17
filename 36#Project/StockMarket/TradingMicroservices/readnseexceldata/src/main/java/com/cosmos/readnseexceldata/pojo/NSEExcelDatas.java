package com.cosmos.readnseexceldata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NSEExcelDatas {
    private List<NSEExcelData> nseExcelDataList;
}
