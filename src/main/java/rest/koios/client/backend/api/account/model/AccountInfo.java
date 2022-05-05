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
     * Account Status
     */
    private String status;

    /**
     * Delegated Pool
     */
    private String delegatedPool;

    /**
     * Account Balance
     */
    private String totalBalance;

    /**
     * Utxo Balance
     */
    private String utxo;

    /**
     * Rewards Balance
     */
    private String rewards;

    /**
     * Withdrawals Amount
     */
    private String withdrawals;

    /**
     * Rewards Available Amount
     */
    private String rewardsAvailable;

    /**
     * Reserves Amount
     */
    private String reserves;

    /**
     * Treasury Amount
     */
    private String treasury;
}
