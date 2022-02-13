package rest.koios.client.backend.factory.options;

import lombok.Getter;

/**
 * Offset
 */
@Getter
public class Offset extends Option {

    private final long offset;

    /**
     * Offset Option Constructor
     *
     * @param offset records offset value
     */
    public Offset(long offset) {
        super(OptionType.OFFSET);
        this.offset = offset;
    }

    /**
     * Offset.of Static Constructor
     *
     * @param offset records offset value
     * @return new Offset Option Object
     */
    public static Offset of(long offset) {
        return new Offset(offset);
    }

    @Override
    public String getValue() {
        return String.valueOf(offset);
    }
}
