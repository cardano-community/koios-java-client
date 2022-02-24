package rest.koios.client.backend.factory.options;

import lombok.Getter;

/**
 * Limit
 */
@Getter
public class Limit extends Option {

    private final long limit;

    /**
     * Limit Option Constructor
     *
     * @param limit records limit value
     */
    public Limit(long limit) {
        super(OptionType.LIMIT);
        this.limit = limit;
    }

    /**
     * Limit.of Static Constructor
     *
     * @param limit records limit value
     * @return new Limit Option Object
     */
    public static Limit of(long limit) {
        if (limit >= 0) {
            return new Limit(limit);
        } else {
            throw new IllegalStateException("Can only Limit by a positive Value");
        }
    }

    @Override
    public String getValue() {
        return String.valueOf(limit);
    }
}
