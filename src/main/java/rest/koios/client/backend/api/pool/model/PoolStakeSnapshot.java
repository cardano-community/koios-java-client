package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Pool Stake Snapshot
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolStakeSnapshot {

    /**
     *
     * Type of snapshot ("Mark", "Set" or "Go")
     */
    private String snapshot;

    /**
     * Epoch number for the snapshot entry
     */
    private Integer epochNo;

    /**
     * The nonce value for this epoch
     */
    private String nonce;

    /**
     * Pool's Active Stake for the given epoch
     */
    private String poolStake;

    /**
     * Total Active Stake for the given epoch
     */
    private String activeStake;
}
