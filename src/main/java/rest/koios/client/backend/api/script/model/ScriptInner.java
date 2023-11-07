package rest.koios.client.backend.api.script.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * Script Inner
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ScriptInner {

    /**
     * Script Type
     */
    private String type;

    /**
     * Script Key Hash
     */
    @JsonProperty("keyHash")
    private String keyHash;

    /**
     * Script Slot
     */
    private Long slot;

    /**
     * Lvl 2 Script Inner
     */
    private ArrayList<ScriptInner> scripts;
}
