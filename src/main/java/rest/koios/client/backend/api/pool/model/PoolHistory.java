package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Pool History
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolHistory {

    /**
     * Epoch for which the pool history data is shown
     */
    private Integer epochNo;

    /**
     * Amount of delegated stake to this pool at the time of epoch snapshot (in lovelaces)
     */
    private String activeStake;

    /**
     * Active stake for the pool, expressed as a percentage of total active stake on network
     */
    private Double activeStakePct;

    /**
     * Saturation percentage of a pool at the time of snapshot (2 decimals)
     */
    private Double saturationPct;

    /**
     * Number of blocks pool created in that epoc
     */
    private Integer blockCnt;

    /**
     * Number of delegators to the pool for that epoch snapshot
     */
    private Integer delegatorCnt;

    /**
     * Margin (decimal format)
     */
    private Double margin;

    /**
     * Pool fixed cost per epoch (in lovelaces)
     */
    private String fixedCost;

    /**
     * Total amount of fees earned by pool owners in that epoch (in lovelaces)
     */
    private String poolFees;

    /**
     * Total amount of rewards earned by delegators in that epoch (in lovelaces)
     */
    private String delegRewards;

    /**
     * Total amount of rewards earned by members (delegator - owner) in that epoch (in lovelaces)
     */
    private String memberRewards;

    /**
     * Annualized ROS (return on staking) for delegators for this epoch
     */
    private Double epochRos;
}
