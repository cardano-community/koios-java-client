package rest.koios.client.backend.api.epoch.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Epoch's Block Protocols
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EpochBlockProtocols {

    /**
     * Protocol major version
     */
    private Integer protoMajor = null;

    /**
     * Protocol minor version
     */
    private Integer protoMinor = null;

    /**
     * Amount of blocks with specified major and protocol combination
     */
    private Integer blocks = null;
}
