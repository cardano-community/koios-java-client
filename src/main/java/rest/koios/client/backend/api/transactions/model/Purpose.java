package rest.koios.client.backend.api.transactions.model;

/**
 * Kind of validation of redeemer
 */
public enum Purpose {
    /**
     * Spend
     */
    spend,

    /**
     * Mint
     */
    mint,

    /**
     * Cert
     */
    cert,

    /**
     * Reward
     */
    reward
}
