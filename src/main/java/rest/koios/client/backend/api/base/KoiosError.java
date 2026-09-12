package rest.koios.client.backend.api.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * Structured error returned by a Koios instance.
 * <p>
 * Koios is served by PostgREST, which reports failures as a JSON object rather than plain text:
 * <pre>
 * {"code":"42703","details":null,"hint":null,"message":"column pgrst_call.ticker does not exist"}
 * </pre>
 * When a failing response carries such a body it is parsed into this object and exposed as the
 * {@code error} field of {@link Result}. Responses whose body is not JSON of this shape leave it
 * null; the raw body is always available from the {@code response} field either way.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class KoiosError {

    /**
     * Error code as reported by the server, e.g. a PostgreSQL SQLSTATE such as "42703"
     * (null if not applicable)
     */
    private String code;

    /**
     * Human readable description of the failure (null if not applicable)
     */
    private String message;

    /**
     * Additional detail about the failure (null if not applicable)
     */
    private String details;

    /**
     * Suggested way to resolve the failure (null if not applicable)
     */
    private String hint;
}
