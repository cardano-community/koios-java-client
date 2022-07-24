package rest.koios.client.backend.api.block.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Block Information
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockInfo {

    /**
     * Hash of the block
     */
    private String hash = null;

    /**
     * Epoch number of the block
     */
    private Integer epochNo = null;

    /**
     * Absolute slot number of the block
     */
    private Integer absSlot = null;

    /**
     * Slot number of the block in epoch
     */
    private Integer epochSlot = null;

    /**
     * Block Height
     */
    private Integer blockHeight = null;

    /**
     * Block size in bytes
     */
    private Long blockSize = null;

    /**
     * Timestamp of the block
     */
    private String blockTime = null;

    /**
     * Number of transactions in the block
     */
    private Integer txCount = null;

    /**
     * VRF key of the block producer
     */
    private String vrfKey = null;

    /**
     * Hash of the block producers' operational certificate
     */
    private String opCert;

    /**
     * Counter value of the operational certificate used to create this block
     */
    private Integer opCertCounter = null;

    /**
     * Pool ID in bech32 format
     */
    private String pool = null;

    /**
     * Total output of the block (in lovelace)
     */
    private String totalOutput;

    /**
     * Total fees of the block (in lovelace)
     */
    private String totalFees;

    /**
     * Number of Confirmations
     */
    private Long numConfirmations;

    /**
     * Parent Block Hash
     */
    private String parentHash;

    /**
     * Child Block Hash
     */
    private String childHash;
}
