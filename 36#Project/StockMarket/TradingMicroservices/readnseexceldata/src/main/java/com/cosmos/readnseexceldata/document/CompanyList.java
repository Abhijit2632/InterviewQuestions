package com.cosmos.readnseexceldata.document;

import com.cosmos.readnseexceldata.pojo.CompanyDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "CompanyList003")
public class CompanyList {
    @Id
    private String companyListId;
    private String companyListName;
    private List<CompanyDetails> companyDetailsList;
    private LocalDate companyListTakenTime;
}
