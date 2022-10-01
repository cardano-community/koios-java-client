package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.ArrayList;

/**
 * Pool Update
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolUpdate {

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;

    /**
     * Pool ID (bech32 format)
     */
    private String poolIdBech32;

    /**
     * Pool ID (Hex format)
     */
    private String poolIdHex;

    /**
     * Epoch number in which the update becomes active
     */
    private Long activeEpochNo;

    /**
     * Pool VRF key hash
     */
    private String vrfKeyHash;

    /**
     * Margin (decimal format)
     */
    private Double margin;

    /**
     * Pool fixed cost per epoch
     */
    private Long fixedCost;

    /**
     * Pool pledge in lovelace
     */
    private Long pledge;

    /**
     * Pool reward address
     */
    private String rewardAddr;

    /**
     * Pool (co)owner addresses
     */
    private ArrayList<String> owners;

    /**
     * Relays
     */
    private ArrayList<Relay> relays;

    /**
     * Pool metadata URL
     */
    private String metaUrl;

    /**
     * Pool metadata hash
     */
    private String metaHash;

    /**
     * Historical metadata information
     */
    private JsonNode metaJson;

    /**
     * Pool status
     * Allowed: registered | retiring | retired
     */
    private String poolStatus;

    /**
     * Announced retiring epoch (nullable)
     */
    private Integer retiringEpoch;
}
