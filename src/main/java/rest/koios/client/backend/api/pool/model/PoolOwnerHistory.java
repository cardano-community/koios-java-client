package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Pool Calidus Key
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolOwnerHistory {

    /**
     * Pool ID (bech32 format)
     */
    private String poolIdBech32;

    /**
     * Individual Stake account registered as (one of the) pool owner(s)
     */
    private String stakeAddress;

    /**
     * Pool pledge in number
     */
    private String declaredPledge;

    /**
     * Epoch for which the pool history data is shown
     */
    private Integer epoch;

    /**
     * Amount of delegated stake to this pool at the time of epoch snapshot
     */
    private String activeStake;
}
