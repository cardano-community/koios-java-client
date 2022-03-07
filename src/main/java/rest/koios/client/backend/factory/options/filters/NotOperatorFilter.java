package rest.koios.client.backend.factory.options.filters;

import lombok.Getter;
import rest.koios.client.backend.factory.options.Option;
import rest.koios.client.backend.factory.options.OptionType;

/**
 * Not Operator Logical Operator Filter
 */
@Getter
public class NotOperatorFilter extends Option {

    private final Option option;

    /**
     * LogicalOperatorFilter Constructor
     *
     * @param option Option to negate
     */
    public NotOperatorFilter(Option option) {
        super(OptionType.NOT_OPERATOR);
        this.option = option;
    }

    /**
     * Filter.of Static Constructor
     *
     * @param option Option to negate
     * @return new NotOperatorFilter Option Object
     */
    public static NotOperatorFilter of(Option option) {
        if (option == null) {
            throw new IllegalStateException("Cannot Negate null Option");
        }
        return new NotOperatorFilter(option);
    }

    @Override
    public String getOptionTypeValue() {
        if (option.getOptionType() == OptionType.LOGICAL_FILTER) {
            return "not." + getOption().getOptionTypeValue();
        } else {
            return getOption().getOptionTypeValue();
        }
    }

    @Override
    public String getValue() {
        if (option.getOptionType() == OptionType.LOGICAL_FILTER) {
            return getOption().getValue();
        } else {
            return "not." + getOption().getValue();
        }
    }
}