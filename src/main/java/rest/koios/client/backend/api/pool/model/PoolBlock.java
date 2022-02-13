package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Pool Block
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolBlock {

    private Long epochNo;

    private Long epochSlotNo;

    private Long blockNo;

    private Long slotNo;

    private String blockHash;

    private String blockTime;
}
