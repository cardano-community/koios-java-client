package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

/**
 * Transaction UTxO
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxUtxo {

    /**
     * Hash of Transaction for which details are being shown
     */
    private String txHash = null;

    /**
     * An array with details about inputs used in a transaction
     */
    private List<TxIO> inputs = null;

    /**
     * An array with details about outputs from the transaction
     */
    private List<TxIO> outputs = null;
}
