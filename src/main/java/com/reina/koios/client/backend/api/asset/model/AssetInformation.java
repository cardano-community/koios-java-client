package com.reina.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AssetInformation {

    private String policyId;

    private String assetName;

    private String assetNameAscii;

    private String fingerprint;

    private Object mintingTxMetadata;

    private String tokenRegistryMetadata;

    private BigInteger totalSupply;

    private String creationTime;
}
