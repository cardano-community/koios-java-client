package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Minting Transaction
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MintingTx {

    /**
     * Transaction Hash
     */
    private String txHash;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;

    /**
     * Quantity minted/burned (negative numbers indicate burn transactions)
     */
    private String quantity;

    /**
     * A JSON array containing details about metadata within transaction
     */
    private JsonNode metadata;
}
