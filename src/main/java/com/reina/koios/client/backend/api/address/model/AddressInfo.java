package com.reina.koios.client.backend.api.address.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressInfo {

    /**
     * Balance of Address for which details are being shown
     */
    private String balance;

    /**
     * Cardano staking address in bech32 format
     */
    private String stakeAddress;

    /**
     * Set of UTxOs of Address for which details are being shown
     */
    private Set<AddressUtxo> utxoSet;
}
