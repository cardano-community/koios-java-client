package com.reina.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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

    private ArrayList<Relay> relays;

    private String metaUrl;

    private String metaHash;

    private String poolStatus;

    private Long retiringEpoch;
}
