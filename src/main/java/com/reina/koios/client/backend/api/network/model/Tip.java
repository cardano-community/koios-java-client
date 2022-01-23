package com.reina.koios.client.backend.api.network.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Tip {

    /**
     * Block Hash in hex
     **/
    private String hash = null;

    /**
     * Epoch number
     **/
    private Integer epoch = null;

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
     * Timestamp for when the block was created
     **/
    private String blockTime = null;
}
