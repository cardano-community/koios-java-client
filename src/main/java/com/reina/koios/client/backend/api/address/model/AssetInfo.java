package com.reina.koios.client.backend.api.address.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AssetInfo {

    /**
     * Asset Policy ID in hexadecimal format (hex)
     */
    private String assetPolicyHex;

    /**
     * Asset Name in hexadecimal format (hex)
     */
    private String assetNameHex;

    /**
     * Asset balance
     */
    private BigInteger quantity;
}
