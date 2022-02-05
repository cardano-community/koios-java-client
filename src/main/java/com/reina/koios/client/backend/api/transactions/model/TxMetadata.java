package com.reina.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxMetadata {

    /**
     * Hash of the transaction for which details are being shown
     */
    private String txHash = null;

    /**
     * A JSON array containing details about metadata within transaction
     */
    private String metadata = null;
}
