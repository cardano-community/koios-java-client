package rest.koios.client.backend.api.network.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Genesis
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Genesis {

    /**
     * Unique network identifier for chain
     **/
    private String networkmagic = null;

    /**
     * Network ID used at various CLI identification to distinguish between Mainnet and other networks
     **/
    private String networkid = null;

    /**
     * Number of slots in an epoch
     **/
    private String epochlength = null;

    /**
     * Duration of a single slot (in seconds)
     **/
    private String slotlength = null;

    /**
     * Maximum smallest units (lovelaces) supply for the blockchain
     **/
    private String maxlovelacesupply = null;

    /**
     * UNIX timestamp of the first block (genesis) on chain
     **/
    private Long systemstart = null;

    /**
     * Active Slot Co-Efficient (f) - determines the _probability_ of number of slots in epoch that are expected to have blocks (so mainnet, this would be: 432000 * 0.05 &#x3D; 21600 estimated blocks)
     **/
    private String activeslotcoeff = null;

    /**
     * Number of slots that represent a single KES period (a unit used for validation of KES key evolutions)
     **/
    private String slotsperkesperiod = null;

    /**
     * Number of KES key evolutions that will automatically occur before a KES (hot) key is expired. This parameter is for security of a pool, in case an operator had access to his hot(online) machine compromised
     **/
    private String maxkesrevolutions = null;

    /**
     * A unit (k) used to divide epochs to determine stability window (used in security checks like ensuring atleast 1 block was created in 3*k/f period, or to finalize next epoch&#x27;s nonce at 4*k/f slots before end of epoch)
     **/
    private String securityparam = null;

    /**
     * Number of BFT members that need to approve (via vote) a Protocol Update Proposal
     **/
    private String updatequorum = null;

    /**
     * A JSON dump of Alonzo Genesis
     **/
    private String alonzogenesis = null;
}
