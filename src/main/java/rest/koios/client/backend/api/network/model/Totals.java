package rest.koios.client.backend.api.network.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Totals
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Totals {

    /**
     * Epoch number
     **/
    private Long epochNo = null;

    /**
     * Circulating UTxOs for given epoch (in lovelaces)
     **/
    private Long circulation = null;

    /**
     * Funds in treasury for given epoch (in lovelaces)
     **/
    private Long treasury = null;

    /**
     * Rewards accumulated as of given epoch (in lovelaces)
     **/
    private Long reward = null;

    /**
     * Total Active Supply (sum of treasury funds, rewards, UTxOs, deposits and fees) for given epoch (in lovelaces)
     **/
    private Long supply = null;

    /**
     * Total Reserves yet to be unlocked on chain
     **/
    private Long reserves = null;
}
