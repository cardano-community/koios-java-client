package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rest.koios.client.backend.api.base.common.Asset;

import java.util.List;

/**
 * Raw Transaction
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RawTx {

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    private String blockHash;

    private Long blockHeight;

    private Integer epochNo;

    private Long absoluteSlot;

    private Long txTimestamp;

    /**
     * Raw Tx in CBOR format
     */
    private String cbor = null;
}
