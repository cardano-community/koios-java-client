package com.reina.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
