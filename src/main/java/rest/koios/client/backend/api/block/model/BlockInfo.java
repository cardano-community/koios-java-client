package rest.koios.client.backend.api.block.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Block Information
 */
@Getter
@Setter
@ToString(callSuper=true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BlockInfo extends Block {

    /**
     * Operational Certificate Hash
     */
    private String opCert;

    /**
     * Parent Block Hash
     */
    private String parentHash;

    /**
     * Child Block Hash
     */
    private String childHash;
}
