package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Asset Summary
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AssetSummary {

    /**
     * Asset Policy ID (hex)
     */
    private String policyId;

    /**
     * Asset Name (hex)
     */
    private String assetName;

    /**
     * Total number of transactions including the given asset
     */
    private Long totalTransactions;

    /**
     * Total number of registered wallets holding the given asset
     */
    private Long stakedWallets;

    /**
     * Total number of payment addresses (not belonging to registered wallets) holding the given asset
     */
    private Long unstakedAddresses;
}
