package rest.koios.client.backend.factory.options;

import lombok.Getter;

/**
 * Option
 */
@Getter
public abstract class Option {

    private final OptionType optionType;

    /**
     * Option Constructor
     *
     * @param optionType optionType
     */
    public Option(OptionType optionType) {
        this.optionType = optionType;
    }

    /**
     * getValue
     *
     * @return abstract value per child Objects
     */
    public abstract String getValue();

    /**
     * getOptionTypeValue
     *
     * @return OptionType Name in lower case
     */
    public String getOptionTypeValue() {
        return optionType.name().toLowerCase();
    }
}
