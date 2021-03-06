package rest.koios.client.backend.api.script.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * Script
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Script {

    /**
     * Script Type
     */
    private String type;

    /**
     * List of Scripts
     */
    private ArrayList<ScriptInner> scripts;

    /**
     * Required Count
     */
    private Integer required;

    /**
     * Key Hash
     */
    @JsonProperty("keyHash")
    private String keyHash;
}
