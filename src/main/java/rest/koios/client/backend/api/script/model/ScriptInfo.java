package rest.koios.client.backend.api.script.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Script Information
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ScriptInfo {

    /**
     * Hash of a script
     */
    private String scriptHash;

    /**
     * Hash of the script creation transaction
     */
    private String creationTxHash;

    /**
     * Type of the script: plutusV1 | plutusV2 | timelock | multisig
     */
    private NativeScriptType type;

    /**
     * Script JSON Object;
     */
    private JsonNode value;

    /**
     * Script bytes (cborSeq)
     */
    private String bytes;

    /**
     * The size of the CBOR serialised script (in bytes)
     */
    private Integer size;
}
