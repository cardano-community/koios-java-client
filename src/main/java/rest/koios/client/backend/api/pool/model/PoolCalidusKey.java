package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Pool Calidus Key
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolCalidusKey {

    /**
     * Pool ID (bech32 format)
     */
    private String poolIdBech32;

    /**
     * Pool status (registered | retiring | retired)
     */
    private String poolStatus;

    /**
     * Unique nonce for pool's calidus key
     */
    private Integer calidusNonce;

    /**
     * Calidus public key as per CIP-88
     */
    private String calidusPubKey;

    /**
     * Calidus key in bech32 format as per CIP-88
     */
    private String calidusIdBech32;

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    /**
     * Epoch number
     */
    private Integer epochNo;

    /**
     * Block Height
     */
    private Integer blockHeight;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;
}
