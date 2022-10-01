package rest.koios.client.backend.api.address.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import rest.koios.client.backend.api.transactions.model.InlineDatum;
import rest.koios.client.backend.api.transactions.model.ReferenceScript;

import java.util.ArrayList;

/**
 * Address UTxO
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressUtxo implements Comparable<AddressUtxo> {

    /**
     * Hash of the UTxO
     */
    private String txHash;

    /**
     * Index of UTxO
     */
    private Integer txIndex;

    /**
     * Block height
     */
    private Integer blockHeight;

    /**
     * Timestamp of the block
     */
    private String blockTime;

    /**
     * Total sum on the output address
     */
    private String value;

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
     * An array of assets which are included in the UTxO
     */
    private ArrayList<Asset> assetList;

    @Override
    public int compareTo(AddressUtxo other) {
        return getBlockHeight().compareTo(other.getBlockHeight());
    }
}
