package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Policy Asset Info
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PolicyAssetInfo {

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
     * Hash of the latest mint transaction
     */
    private String mintingTxHash;

    /**
     * Count of total mint transactions
     */
    private Integer mintCnt;

    /**
     * Count of total burn transactions
     */
    private Integer burnCnt;

    /**
     * Creation Time
     */
    private Integer creationTime;

    /**
     * A JSON array containing details about metadata within transaction
     */
    private JsonNode mintingTxMetadata;

    /**
     * Asset metadata registered on the Cardano Token Registry
     */
    private TokenRegistryMetadata tokenRegistryMetadata;
}
