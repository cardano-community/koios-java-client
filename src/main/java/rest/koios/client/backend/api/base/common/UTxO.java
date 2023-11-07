package rest.koios.client.backend.api.base.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * UTxO
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UTxO {

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    /**
     * Index of UTxO in the transaction
     */
    private Integer txIndex;

    /**
     * A Cardano payment/base address (bech32 encoded)
     */
    private String address;

    /**
     * Total sum of ADA on the UTxO
     */
    private String value;

    /**
     * Cardano staking address (reward account) in bech32 format
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
     * UNIX timestamp of the block
     */
    private Integer blockTime;

    /**
     * The Hash of the Plutus Data
     */
    private String datumHash;

    /**
     * Allows datums to be attached to UTxO (CIP-32)
     */
    private InlineDatum inlineDatum;

    /**
     * Allow reference scripts to be used to satisfy script requirements during validation, rather than requiring the spending transaction to do so. (CIP-33)
     */
    private ReferenceScript referenceScript;

    /**
     * List of assets on the UTxO
     */
    private List<Asset> assetList;

    /**
     * True if the UTXO has been spent
     */
    private Boolean isSpent;
}
