package rest.koios.client.backend.api.address.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import rest.koios.client.backend.api.base.common.Asset;
import rest.koios.client.backend.api.base.common.InlineDatum;
import rest.koios.client.backend.api.base.common.ReferenceScript;

import java.util.ArrayList;

/**
 * Address UTxO
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
    private Integer blockTime;

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
        int comparison1 = getBlockHeight().compareTo(other.getBlockHeight());
        if (comparison1 == 0) {
            return getTxIndex().compareTo(other.getTxIndex());
        }
        return comparison1;
    }
}
