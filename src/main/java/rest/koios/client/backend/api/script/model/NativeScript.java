package rest.koios.client.backend.api.script.model;

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
public class NativeScript {

    /**
     * Hash of a script
     */
    private String scriptHash;

    /**
     * Hash of the script creation transaction
     */
    private String creationTxHash;

    /**
     * Type of the script
     */
    private NativeScriptType type;

    /**
     * Script
     */
    private Script script;
}
