package com.reina.koios.client.backend.api.block.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Block {

    /**
     * Block Hash in hex
     */
    private String hash = null;

    /**
     * Epoch number
     */
    private Integer epoch = null;

    /**
     * Absolute Slot number (slots not divided into epochs)
     */
    private Integer absSlot = null;

    /**
     * Slot number within Epoch
     */
    private Integer epochSlot = null;

    /**
     * Block Height number on chain
     */
    private Integer height = null;

    /**
     * Timestamp for when the block was created
     */
    private String blockTime = null;

    /**
     * Number of transactions submitted in epoch
     */
    private Integer txCount = null;

    /**
     * VRF key of the creator of the block
     */
    private String vrfKey = null;

    /**
     * Bech32 encoding of the pool hash which created the block
     */
    private String pool = null;

    /**
     * The value of the counter used to produce the operational certificate
     */
    private Integer opCertCounter = null;
}
