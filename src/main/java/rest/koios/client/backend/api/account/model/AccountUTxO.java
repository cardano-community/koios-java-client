package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * AccountUTxO
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountUTxO {

    /**
     * Hash of transaction for UTxO
     */
    private String txHash;

    /**
     * Index of UTxO in the transaction
     */
    private Integer txIndex;

    /**
     * A Cardano payment/base address (bech32 encoded) for transaction's input UTxO
     */
    private String address;

    /**
     * Total sum of ADA on the UTxO
     */
    private String value;

    /**
     * Block height
     */
    private Integer blockHeight;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;
}
