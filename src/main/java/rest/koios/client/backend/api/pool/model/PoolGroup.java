package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Pool Group
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolGroup {

    /**
     * Pool ID (bech32 format)
     */
    private String poolIdBech32;

    /**
     * A group that the pool was identified to be associated with
     */
    private String poolGroup;

    /**
     * Pool ticker
     */
    private String ticker;

    /**
     * The pool's group identification as per adastat.net
     */
    private String adastatGroup;

    /**
     * The pool's group identification as per balanceanalytics.io
     */
    private String balanceanalyticsGroup;
}
