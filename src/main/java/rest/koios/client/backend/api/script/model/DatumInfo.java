package rest.koios.client.backend.api.script.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Datum Info
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DatumInfo {

    /**
     * The Hash of the Plutus Data
     */
    private String datumHash;

    /**
     * Hash of the script creation transaction
     */
    private String creationTxHash;

    /**
     * The actual data in json format
     */
    private JsonNode value;

    /**
     * Script bytes (cborSeq)
     */
    private String bytes;
}
