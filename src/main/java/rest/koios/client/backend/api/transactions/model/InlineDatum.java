package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Inline Datum
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InlineDatum {

    /**
     * Datum (hex)
     */
    private String bytes;

    /**
     * Value (json)
     */
    private JsonNode value;
}
