package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Account Tx
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountTx {

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    /**
     * Epoch number of the block
     */
    private Integer epochNo;

    /**
     * Block height
     */
    private Integer blockHeight;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;
}
