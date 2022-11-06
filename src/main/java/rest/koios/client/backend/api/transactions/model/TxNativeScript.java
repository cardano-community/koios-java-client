package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Native Script
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxNativeScript {

    /**
     * Hash of a script
     */
    private String scriptHash;

    /**
     * JSON representation of the timelock script (null for other script types)
     */
    private JsonNode scriptJson;
}
