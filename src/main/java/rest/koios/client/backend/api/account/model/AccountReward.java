package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Account Rewards Inner
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountReward {

    /**
     * Earned Rewards Epoch
     */
    private Integer earnedEpoch;

    /**
     * Spendable Epoch
     */
    private Integer spendableEpoch;

    /**
     * Amount of rewards earned (in lovelace)
     */
    private String amount;

    /**
     * The source of the rewards
     * Allowed: member|leader|treasury|reserves
     */
    private String type;

    /**
     * Bech32 representation of pool ID
     */
    private String poolId;
}
