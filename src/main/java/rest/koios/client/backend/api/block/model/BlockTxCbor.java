package rest.koios.client.backend.api.block.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Block Tx Cbor
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BlockTxCbor {

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    /**
     * Hash of the block
     */
    private String blockHash;

    /**
     * Block height
     */
    private Integer blockHeight;

    /**
     * Epoch number of the block
     */
    private Integer epochNo;

    /**
     * Absolute slot number of the block
     */
    private Integer absoluteSlot;

    /**
     * UNIX timestamp of the transaction
     */
    private Integer txTimestamp;

    /**
     * CBOR encoded raw transaction
     */
    private String cbor;
}
