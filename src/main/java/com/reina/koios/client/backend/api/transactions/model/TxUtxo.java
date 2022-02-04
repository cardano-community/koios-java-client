package com.reina.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxUtxo {

    /**
     * Hash of Transaction for which details are being shown
     */
    private String txHash = null;

    /**
     * An array with details about inputs used in a transaction
     */
    private List<Object> inputs = null;

    /**
     * An array with details about outputs from the transaction
     */
    private List<Object> outputs = null;
}
