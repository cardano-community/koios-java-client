package rest.koios.client.backend.api.network.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private Integer epochNo = null;

    /**
     * Circulating UTxOs for given epoch (in lovelaces)
     **/
    private String circulation = null;

    /**
     * Funds in treasury for given epoch (in lovelaces)
     **/
    private String treasury = null;

    /**
     * Rewards accumulated as of given epoch (in lovelaces)
     **/
    private String reward = null;

    /**
     * Total Active Supply (sum of treasury funds, rewards, UTxOs, deposits and fees) for given epoch (in lovelaces)
     **/
    private String supply = null;

    /**
     * Total Reserves yet to be unlocked on chain
     **/
    private String reserves = null;

    /**
     * The amount (in Lovelace) in the fee pot
     */
    private String fees;

    /**
     * The amount (in Lovelace) in the obligation pot coming from stake key and pool deposits.
     */
    private String depositsStake;

    /**
     * The amount (in Lovelace) in the obligation pot coming from drep registrations deposits.
     */
    private String depositsDrep;

    /**
     * The amount (in Lovelace) in the obligation pot coming from governance proposal deposits.
     */
    private String depositsProposal;
}
