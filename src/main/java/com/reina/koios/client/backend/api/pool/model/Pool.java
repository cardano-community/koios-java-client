package com.reina.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Pool {

    /**
     * Bech32 representation of pool ID
     */
    private String poolIdBech32 = null;

    /**
     * Pool ticker
     */
    private String ticker = null;
}
