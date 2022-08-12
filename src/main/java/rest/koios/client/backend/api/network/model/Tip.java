package rest.koios.client.backend.api.network.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

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
    private Integer blockNo = null;

    /**
     * UNIX timestamp of the block
     **/
    private Long blockTime = null;
}
