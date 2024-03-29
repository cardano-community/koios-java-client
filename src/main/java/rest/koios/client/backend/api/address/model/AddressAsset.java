package rest.koios.client.backend.api.address.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rest.koios.client.backend.api.base.common.Asset;

/**
 * Address Asset
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressAsset extends Asset {

    /**
     * A Cardano payment/base address (bech32 encoded) for transaction's input UTxO
     */
    private String address;
}
