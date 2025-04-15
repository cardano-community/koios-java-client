package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Policy Asset
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PolicyAsset {

    /**
     * Asset Name (hex)
     */
    private String assetName;

    /**
     * The CIP14 fingerprint of the asset
     */
    private String fingerprint;

    /**
     * Total Supply
     */
    private String totalSupply;

    /**
     * Asset decimals
     */
    private Integer decimals;
}
