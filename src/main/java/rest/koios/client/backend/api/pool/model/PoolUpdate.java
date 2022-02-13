package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.ArrayList;

/**
 * Pool Update
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolUpdate {

    private String txHash;

    private String blockTime;

    private String poolIdBech32;

    private String poolIdHex;

    private Long activeEpochNo;

    private String vrfKeyHash;

    private Integer margin;

    private Long fixedCost;

    private Long pledge;

    private String rewardAddr;

    private ArrayList<String> owners;

    private ArrayList<rest.koios.client.backend.api.pool.model.Relay> relays;

    private String metaUrl;

    private String metaHash;

    private String poolStatus;

    private Long retiringEpoch;
}
