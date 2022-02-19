package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigInteger;

/**
 * Account Asset
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountAsset {

    /**
     * Asset Policy ID (hex)
     */
    private String assetPolicy;

    /**
     * Asset Name (hex)
     */
    private String assetName;

    /**
     * Sum of assets for UTxO
     */
    private BigInteger quantity;
}
