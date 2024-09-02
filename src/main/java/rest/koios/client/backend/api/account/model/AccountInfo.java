package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Account Information
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountInfo {

    /**
     * Cardano staking address (reward account) in bech32 format
     */
    private String stakeAddress;

    /**
     * Stake address status
     * Allowed: registered | not registered
     */
    private String status;

    /**
     * Account's current delegation status to DRep ID in CIP-129 Bech32 format
     */
    private String delegatedDrep;

    /**
     * Delegated Pool ID (bech32 format)
     */
    private String delegatedPool;

    /**
     * Total balance of the account including UTxO, rewards and MIRs (in number)
     */
    private String totalBalance;

    /**
     * Total UTxO balance of the account
     */
    private String utxo;

    /**
     * Total rewards earned by the account
     */
    private String rewards;

    /**
     * Total rewards withdrawn by the account
     */
    private String withdrawals;

    /**
     * Total rewards available for withdrawal
     */
    private String rewardsAvailable;

    /**
     * Total deposit available for withdrawal
     */
    private String deposit;

    /**
     * Total reserves MIR value of the account
     */
    private String reserves;

    /**
     * Total treasury MIR value of the account
     */
    private String treasury;
}
