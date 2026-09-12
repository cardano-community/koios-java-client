package rest.koios.client.backend.api.network.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Era Summary
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EraSummary {

    /**
     * Cardano Era
     */
    private String era;

    /**
     * Protocol major version
     */
    private Integer protocolMajor;

    /**
     * Protocol minor version
     */
    private Integer protocolMinor;

    /**
     * Protocol name that denotes collection of features sitting between consensus and ledger layer
     */
    private String ledgerProtocol;

    /**
     * Consensus name that denotes collection of consensus features introduced at a hard fork
     */
    private String consensusMechanism;

    /**
     * Additional information about when this protocol update was pushed (if there is a fork name associated)
     */
    private String notes;

    /**
     * Epoch number
     */
    private Integer epochNo;

    /**
     * UNIX timestamp of the first block in the epoch
     */
    private Long firstBlockTime;

    /**
     * Hash of the first block in the epoch
     */
    private String firstBlockHash;
}
