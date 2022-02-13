package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Account Rewards
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountRewards {

    /**
     * Earned Rewards Epoch
     */
    private Long earnedEpoch;

    /**
     * Spendable Epoch
     */
    private Long spendableEpoch;

    /**
     * Rewards Amount
     */
    private Long amount;

    /**
     * Rewards Type
     */
    private String type;

    /**
     * Pool Id
     */
    private String poolId;
}
