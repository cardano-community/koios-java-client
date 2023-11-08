package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
    private String fixedCost;

    /**
     * Pool pledge in lovelace
     */
    private String pledge;

    /**
     * Pool reward address
     */
    private String rewardAddr;

    /**
     * Pool (co)owner addresses
     */
    private List<String> owners;

    /**
     * Relays
     */
    private List<Relay> relays;

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
    private MetaJson metaJson;

    /**
     * Pool status
     * Allowed: registration|deregistration
     */
    private String updateType;

    /**
     * Announced retiring epoch (nullable)
     */
    private Integer retiringEpoch;
}
