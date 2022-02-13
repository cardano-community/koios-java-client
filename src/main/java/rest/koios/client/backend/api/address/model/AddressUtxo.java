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
public class AddressUtxo {

    /**
     * Hash of the UTxO
     */
    private String txHash;

    /**
     * Index of UTxO
     */
    private Integer txIndex;

    /**
     * Total sum on the output address
     */
    private Long value;

    /**
     * An array of assets which are included in the UTxO
     */
    private ArrayList<Asset> assetList;
}
