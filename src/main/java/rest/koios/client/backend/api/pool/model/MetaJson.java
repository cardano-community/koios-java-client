package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Meta Json
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MetaJson {

    /**
     * Pool name
     */
    private String name;

    /**
     * Pool ticker
     */
    private String ticker;

    /**
     * Pool homepage URL
     */
    private String homepage;

    /**
     * Pool description
     */
    private String description;
}
