package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Asset Inner
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AssetInner {

    /**
     * Asset Name (ASCII)
     */
    private String assetName;

    /**
     * Asset Policy ID (hex)
     */
    private String assetPolicy;

    /**
     * Asset quantity owned by account
     */
    private String balance;
}
