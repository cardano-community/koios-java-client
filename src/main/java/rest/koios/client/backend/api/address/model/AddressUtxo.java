package rest.koios.client.backend.api.address.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

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
     * An array of assets which are included in the UTxO
     */
    private ArrayList<Asset> assetList;

    @Override
    public int compareTo(AddressUtxo other) {
        return getBlockHeight().compareTo(other.getBlockHeight());
    }
}
