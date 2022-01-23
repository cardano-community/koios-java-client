package com.reina.koios.client.backend.api.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountHistory {

    /**
     * Cardano staking address (reward account) in bech32 format
     */
    private String stakeAddress = null;

    /**
     * Bech32 representation of pool ID
     */
    private String poolId = null;

    /**
     * Epoch number
     */
    private Integer epochNo = null;

    /**
     * Active stake amount (in lovelaces)
     */
    private Long activeStake = null;
}
