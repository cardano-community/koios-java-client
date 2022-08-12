package rest.koios.client.backend.api.epoch.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Epoch Information
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EpochInfo {

    /**
     * Epoch number
     */
    private Integer epochNo = null;

    /**
     * Total output value across all transactions in epoch
     */
    private Long outSum = null;

    /**
     * Total fees incurred by transactions in epoch
     */
    private Long fees = null;

    /**
     * Number of transactions submitted in epoch
     */
    private Integer txCount = null;

    /**
     * Number of blocks created in epoch
     */
    private Integer blkCount = null;

    /**
     * UNIX timestamp of the epoch start
     */
    private Long startTime;

    /**
     * UNIX timestamp of the epoch end
     */
    private Long endTime;

    /**
     * UNIX timestamp of the epoch's first block
     */
    private Long firstBlockTime = null;

    /**
     * UNIX timestamp of the epoch's last block
     */
    private Long lastBlockTime = null;

    /**
     * Rewards accumulated as of given epoch (in lovelaces)
     */
    private Long activeStake = null;

    /**
     * Total rewards earned in epoch (null for pre-Shelley epochs)
     */
    private String totalRewards;

    /**
     * Average block reward for epoch (null for pre-Shelley epochs)
     */
    private String avgBlkReward;
}
