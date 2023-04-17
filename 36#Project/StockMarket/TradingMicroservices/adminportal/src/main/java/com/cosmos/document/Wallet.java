package com.cosmos.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "wallet003")
public class Wallet {
    @Id
    private Long txId;
    private Long walletId;
    @JsonProperty("cash")
    private Float cash;
    @JsonProperty("isWithdrawal")
    private boolean isWithdrawal;
    @JsonProperty("txDate")
    private LocalDate txDate;
    @JsonProperty("totalCash")
    private Float totalCash;
}
