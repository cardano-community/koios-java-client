package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Pool Metadata
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolMetadata {

    /**
     * Pool ID (bech32 format)
     */
    private String poolIdBech32;

    /**
     * Pool metadata URL
     */
    private String metaUrl;

    /**
     * Pool metadata hash
     */
    private String metaHash;

    /**
     * Metadata Json Object
     */
    private MetaJson metaJson;
}
