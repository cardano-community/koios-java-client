package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Pool
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Pool {

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
    private Integer activeEpochNo;

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
     * Pool's registration deposit in number
     */
    private String deposit;

    /**
     * Pool reward address
     */
    private String rewardAddr;

    /**
     * List of Pool (co)owner address
     */
    private List<String> owners;

    /**
     * List of Pool Relays
     */
    private List<Relay> relays;

    /**
     * Pool ticker
     */
    private String ticker;

    /**
     * A group that the pool was identified to be associated with
     */
    private String poolGroup;

    /**
     * Pool metadata URL
     */
    private String metaUrl;

    /**
     * Pool metadata hash
     */
    private String metaHash;

    /**
     * Pool status (registered | retiring | retired)
     */
    private String poolStatus;

    /**
     * Amount of delegated stake to this pool at the time of epoch snapshot
     */
    private String activeStake;

    /**
     * Announced retiring epoch (nullable)
     */
    private Integer retiringEpoch;

}
