package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Pool Delegator
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolDelegator {

    /**
     * Cardano staking address (reward account) in bech32 format
     */
    private String stakeAddress;

    /**
     * Current delegator live stake (in lovelace)
     */
    private String amount;

    /**
     * Epoch number in which the delegation becomes active
     */
    private Integer activeEpochNo;

    /**
     * Latest transaction hash used for delegation by the account
     */
    private String latestDelegationHash;
}
