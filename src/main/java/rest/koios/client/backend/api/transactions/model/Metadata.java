package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Metadata present within a transaction (if any)
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Metadata {

    /**
     * Metadata key (index)
     */
    private Integer key;

    /**
     * A JSON containing details about metadata within a transaction
     */
    private JsonNode json;
}
