package com.cosmos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "order003")
public class Shareorder {
    @Id
    private String orderId;
    private String orderType;
    private String companyName;
    private Float priceAt;
    private Float quantityOf;
    private Float totalSpend;
    private String comment;
    private LocalDate orderedAt;
    private boolean orderStatus;
}
