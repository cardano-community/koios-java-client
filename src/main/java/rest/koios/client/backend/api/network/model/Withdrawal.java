package rest.koios.client.backend.api.network.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Withdrawal
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Withdrawal {

    /**
     * Epoch number
     **/
    private Integer epochNo;

    /**
     * Slot number of the block in epoch
     **/
    private Integer epochSlot;

    /**
     * Hash identifier of the transaction
     **/
    private String txHash;

    /**
     * Hash of the block
     **/
    private String blockHash;

    /**
     * Block height
     **/
    private Integer blockHeight;

    /**
     * Current delegator live stake (in lovelace)
     **/
    private String amount;

    /**
     * Cardano staking address (reward account) in bech32 format
     **/
    private String stakeAddress;

    /**
     * Epoch where amount is earned
     */
    private Integer earnedEpoch;

    /**
     * Epoch where the earned amount can be spent
     */
    private Integer spendableEpoch;
}
