package rest.koios.client.backend.api.script.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Script
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Script {

    /**
     * Hash of a script
     */
    private String scriptHash;

    /**
     * Hash of the script creation transaction
     */
    private String creationTxHash;
}
