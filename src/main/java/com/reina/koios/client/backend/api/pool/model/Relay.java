package com.reina.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Relay {

    /**
     * DNS name of the relay (nullable)
     */
    private String dns;

    /**
     * DNS service name of the relay (nullable)
     */
    private String srv;

    /**
     * IPv4 address of the relay (nullable)
     */
    private String ipv4;

    /**
     * IPv6 address of the relay (nullable)
     */
    private String ipv6;

    /**
     * Port number of the relay (nullable)
     */
    private Integer port;
}
