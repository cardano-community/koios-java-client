package rest.koios.client.backend.api.base.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Reference Script
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReferenceScript {

    /**
     * Hash of referenced script
     */
    private String hash;

    /**
     * Size in bytes
     */
    private Integer size;

    /**
     * Type of script
     */
    private String type;

    /**
     * Script bytes (hex)
     */
    private String bytes;

    /**
     * Value (json)
     */
    private JsonNode value;
}
