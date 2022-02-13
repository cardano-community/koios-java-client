package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Transaction Status
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxStatus {

    /**
     * Hash of the transaction for which details are being shown
     */
    private String txHash = null;

    /**
     * Number of block confirmations
     */
    private Integer numConfirmations = null;
}
