package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Minting Transaction Metadata
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MintingTxMetadata {

    /**
     * The metadata key
     */
    private String key;

    /**
     * The minting Tx JSON payload if it can be decoded as JSON
     */
    private Object json;
}
