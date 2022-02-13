package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.ArrayList;

/**
 * Asset Names
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AssetNames {

    /**
     * Asset Names (hex)
     */
    private ArrayList<String> hex;

    /**
     * Asset Names (ASCII)
     */
    private ArrayList<String> ascii;
}
