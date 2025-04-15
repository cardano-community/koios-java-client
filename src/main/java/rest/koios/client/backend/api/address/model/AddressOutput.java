package rest.koios.client.backend.api.address.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Address Output
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressOutput {

    /**
     * A Cardano payment/base address (bech32 encoded)
     */
    private String address;

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    /**
     * Index of UTxO in the transaction
     */
    private Integer txIndex;

    /**
     * Total sum of ADA on the UTxO
     */
    private String value;

    /**
     * Cardano staking address (reward account) in bech32
     */
    private String stakeAddress;

    /**
     * Payment credential
     */
    private String paymentCred;

    /**
     * Epoch number of the block
     */
    private Integer epochNo;

    /**
     * Block height
     */
    private Integer blockHeight;

    /**
     * Timestamp of the block
     */
    private Integer blockTime;

    /**
     * True if the UTXO has been spent
     */
    private Boolean isSpent;
}
