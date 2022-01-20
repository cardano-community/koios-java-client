package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * PoolListInner
 */
public class PoolListInner {

    @SerializedName("pool_id_bech32")
    private String poolIdBech32 = null;

    @SerializedName("ticker")
    private String ticker = null;

    public PoolListInner poolIdBech32(String poolIdBech32) {
        this.poolIdBech32 = poolIdBech32;
        return this;
    }

    /**
     * Bech32 representation of pool ID
     *
     * @return poolIdBech32
     **/
    @Schema(example = "pool1z5uqdk7dzdxaae5633fqfcu2eqzy3a3rgtuvy087fdld7yws0xt", description = "Bech32 representation of pool ID")
    public String getPoolIdBech32() {
        return poolIdBech32;
    }

    public void setPoolIdBech32(String poolIdBech32) {
        this.poolIdBech32 = poolIdBech32;
    }

    public PoolListInner ticker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    /**
     * Pool ticker
     *
     * @return ticker
     **/
    @Schema(example = "JAZZ", description = "Pool ticker")
    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PoolListInner poolListInner = (PoolListInner) o;
        return Objects.equals(this.poolIdBech32, poolListInner.poolIdBech32) &&
                Objects.equals(this.ticker, poolListInner.ticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poolIdBech32, ticker);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PoolListInner {\n");

        sb.append("    poolIdBech32: ").append(toIndentedString(poolIdBech32)).append("\n");
        sb.append("    ticker: ").append(toIndentedString(ticker)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
