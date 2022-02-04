package com.reina.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Asset {

    /**
     * Asset Policy ID (hex)
     */
    private String policyId;

    /**
     * AssetNames Object
     */
    private AssetNames assetNames;
}
