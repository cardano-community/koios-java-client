package rest.koios.client.backend.api.network.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Tip
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Tip {

    /**
     * Block Hash in hex
     **/
    private String hash = null;

    /**
     * Epoch number
     **/
    private Integer epochNo = null;

    /**
     * Absolute Slot number (slots not divided into epochs)
     **/
    private Integer absSlot = null;

    /**
     * Slot number within Epoch
     **/
    private Integer epochSlot = null;

    /**
     * Block Height number on chain
     **/
    @Deprecated
    private Integer blockNo = null;

    /**
     * Block Height
     */
    private Integer blockHeight;

    /**
     * UNIX timestamp of the block
     **/
    private Long blockTime = null;
}
