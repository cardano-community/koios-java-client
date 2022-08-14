package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * TX Input or Output
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxIO {

    /**
     * A Cardano payment/base address for transaction's input/output UTxO
     */
    private TxPaymentAddress paymentAddr;

    /**
     * A Cardano staking address (reward account, bech32 encoded) for transaction's input/output UTxO
     */
    private String stakeAddr;

    /**
     * Hash of this transaction
     */
    private String txHash;

    /**
     * Index of output UTxO
     */
    private Integer txIndex;

    /**
     * Total sum on the output address
     */
    private String value;

    /**
     * Hash of datum (if any) connected to UTxO
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
     * An array of assets included in input/output UTxO
     */
    private List<TxAsset> assetList;
}
