package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Asset
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Asset {

    /**
     * Asset Policy ID (hex)
     */
    private String policyId;

    /**
     * Asset Name (hex)
     */
    private String assetName;

    /**
     * The CIP14 fingerprint of the asset
     */
    private String fingerprint;
}
