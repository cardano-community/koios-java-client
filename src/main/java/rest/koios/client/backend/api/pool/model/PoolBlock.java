package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Pool Block
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolBlock {

    /**
     * Epoch number
     */
    private Integer epochNo;

    /**
     * Slot number of the block in epoch
     */
    private Integer epochSlot;

    /**
     * Absolute slot number of the block
     */
    private Integer absSlot;

    /**
     * Block height
     */
    private Integer blockHeight;

    /**
     * Hash of the block
     */
    private String blockHash;

    /**
     * Timestamp of the block
     */
    private Integer blockTime;
}
