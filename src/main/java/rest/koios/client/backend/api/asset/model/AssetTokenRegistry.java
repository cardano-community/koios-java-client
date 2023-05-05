package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Asset
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AssetTokenRegistry {

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
     * Ticker
     */
    private String ticker;

    /**
     * Description
     */
    private String description;

    /**
     * Url
     */
    private String url;

    /**
     * Decimals
     */
    private Integer decimals;

    /**
     * A PNG image file as a byte string
     */
    private String logo;
}
