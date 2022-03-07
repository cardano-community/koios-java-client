package rest.koios.client.backend.factory.options.filters;

import lombok.Getter;
import rest.koios.client.backend.factory.options.Option;
import rest.koios.client.backend.factory.options.OptionType;

/**
 * Filter
 */
@Getter
public class Filter extends Option {

    private final FilterType filterType;
    private final String field;
    private final String value;

    /**
     * Filter Constructor
     *
     * @param field      field
     * @param filterType filterType
     * @param value      value
     */
    public Filter(String field, FilterType filterType, String value) {
        super(OptionType.FILTER);
        this.filterType = filterType;
        this.field = field;
        this.value = value;
    }

    /**
     * Filter.of Static Constructor
     *
     * @param field      field
     * @param filterType filterType
     * @param value      value
     * @return new Limit Option Object
     */
    public static Filter of(String field, FilterType filterType, String value) {
        return new Filter(field, filterType, value);
    }

    @Override
    public String getOptionTypeValue() {
        return field;
    }

    @Override
    public String getValue() {
        return filterType.name().toLowerCase()+"."+value;
    }
}
