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
     * Asset Name (ASCII)
     */
    private String assetNameAscii;

    /**
     * The CIP14 fingerprint of the asset
     */
    private String fingerprint;

    /**
     * Minting Transaction Metadata
     */
    private MintingTxMetadata mintingTxMetadata;

    /**
     * Asset metadata registered on the Cardano Token Registry
     */
    private TokenRegistryMetadata tokenRegistryMetadata;

    /**
     * Total Supply
     */
    private String totalSupply;

    /**
     * Creation Time
     */
    private String creationTime;
}
