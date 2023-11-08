package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Asset Information
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AssetInformation {

    /**
     * Asset Policy ID (hex)
     */
    private String policyId;

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
     * Hash of the first mint transaction
     */
    private String mintingTxHash;

    /**
     * Total supply for the asset
     */
    private String totalSupply;

    /**
     * Count of total mint transactions
     */
    private Integer mintCnt;

    /**
     * Count of total burn transactions
     */
    private Integer burnCnt;

    /**
     * UNIX timestamp of the first asset mint
     */
    private Long creationTime;

    /**
     * Latest minting transaction metadata (aligns with CIP-25)
     */
    private JsonNode mintingTxMetadata;

    /**
     * Asset metadata registered on the Cardano Token Registry
     */
    private TokenRegistryMetadata tokenRegistryMetadata;

    /**
     * CIP 68 metadata if present for asset
     */
    private JsonNode cip68Metadata;
}
