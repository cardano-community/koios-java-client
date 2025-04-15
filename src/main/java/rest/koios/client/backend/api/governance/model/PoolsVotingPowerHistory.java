package rest.koios.client.backend.api.governance.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Pools Voting Power History
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolsVotingPowerHistory {

    /**
     * Pool ID (bech32 format)
     */
    private String poolIdBech32;

    /**
     * Epoch number of the block
     */
    private Integer epochNo;

    /**
     * The voting power for the pool for the epoch
     */
    private String amount;
}
