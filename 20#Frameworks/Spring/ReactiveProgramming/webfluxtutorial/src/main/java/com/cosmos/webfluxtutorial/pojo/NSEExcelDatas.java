package com.cosmos.webfluxtutorial.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NSEExcelDatas {
    @JsonProperty("nseExcelDataList")
    private List<NSEExcelData> nseExcelDataList;
}
