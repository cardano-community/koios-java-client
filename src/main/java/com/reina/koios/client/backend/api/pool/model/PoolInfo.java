package com.reina.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolInfo {

    /**
     * Pool ID (bech32 format)
     */
    private String poolIdBech32;

    /**
     * Pool ID (Hex format)
     */
    private String poolIdHex;

    /**
     * Block number on chain where transaction was included
     */
    private Long activeEpochNo;

    /**
     * Pool VRF key hash
     */
    private String vrfKeyHash;

    /**
     * Margin (decimal format)
     */
    private Double margin;

    /**
     * Pool fixed cost per epoch
     */
    private Long fixedCost;

    /**
     * Pool pledge in lovelace
     */
    private Long pledge;

    /**
     * Pool reward address
     */
    private String rewardAddr;

    /**
     * List of Pool (co)owner address
     */
    private ArrayList<String> owners;

    /**
     * List of Pool Relays
     */
    private ArrayList<Relay> relays;

    /**
     * Pool metadata URL
     */
    private String metaUrl;

    /**
     * Pool metadata hash
     */
    private String metaHash;

    /**
     * Pool Metadata json
     */
    private MetaJson metaJson;

    /**
     * Pool status (registered | retiring | retired)
     */
    private String poolStatus;

    /**
     * Announced retiring epoch (nullable)
     */
    private Long retiringEpoch;

    /**
     * Pool latest operational certificate hash
     */
    private String opCert;

    /**
     * Pool latest operational certificate counter value
     */
    private Long opCertCounter;

    /**
     * Pool active stake
     */
    private Long activeStake;

    /**
     * Total pool blocks on chain
     */
    private Long epochBlockCnt;

    /**
     * Pool live stake
     */
    private Long liveStake;

    /**
     * Pool live delegator count
     */
    private Long liveDelegators;

    /**
     * Pool live saturation (decimal format)
     */
    private Double liveSaturation;
}
