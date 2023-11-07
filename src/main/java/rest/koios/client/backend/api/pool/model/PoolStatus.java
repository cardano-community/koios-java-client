package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Pool Status
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolStatus {

    /**
     * Pool ID (bech32 format)
     */
    private String poolIdBech32;

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
     * Epoch number
     */
    private Integer epochNo;

    /**
     * Slot number of the block in epoch
     */
    private Integer epochSlot;

    /**
     * Epoch number in which the update becomes active
     */
    private Integer activeEpochNo;
}
