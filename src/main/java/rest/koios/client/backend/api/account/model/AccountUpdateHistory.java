package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Account Update History
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountUpdateHistory {

    /**
     * Cardano staking address (reward account) in bech32 format
     */
    private String stakeAddress;

    /**
     * Type of certificate submitted
     * Allowed: registration | delegation | withdrawal | deregistration
     */
    private String actionType;

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    /**
     * Epoch number of the block
     */
    private Integer epochNo;

    /**
     * Slot number of the block in epoch
     */
    private Integer epochSlot;

    /**
     * Absolute slot number of the block
     */
    private Integer absoluteSlot;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;
}
