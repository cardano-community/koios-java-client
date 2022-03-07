package rest.koios.client.backend.factory.options.filters;

import lombok.Getter;
import rest.koios.client.backend.factory.options.Option;
import rest.koios.client.backend.factory.options.OptionType;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Logical Operator Filter
 */
@Getter
public class LogicalOperatorFilter extends Option {

    private final List<Option> options;
    private final LogicalOperatorFilterType logicalOperatorFilterType;

    /**
     * LogicalOperatorFilter Constructor
     *
     * @param logicalOperatorFilterType logicalOperatorFilterType
     * @param options List of Options
     */
    public LogicalOperatorFilter(LogicalOperatorFilterType logicalOperatorFilterType, List<Option> options) {
        super(OptionType.LOGICAL_FILTER);
        this.logicalOperatorFilterType = logicalOperatorFilterType;
        this.options = options;
    }

    /**
     * Filter.of Static Constructor
     *
     * @param options options List
     * @return new LogicalOperatorFilter Option Object
     */
    public static LogicalOperatorFilter of(LogicalOperatorFilterType logicalOperatorFilterType, Option... options) {
        if (options == null || options.length == 0) {
            throw new IllegalStateException("At least one Option Object is required");
        }
        return new LogicalOperatorFilter(logicalOperatorFilterType, Arrays.stream(options).collect(Collectors.toList()));
    }

    @Override
    public String getOptionTypeValue() {
        return getLogicalOperatorFilterType().name().toLowerCase();
    }

    @Override
    public String getValue() {
        StringJoiner stringJoiner = new StringJoiner(",");
        getOptions().forEach(option -> stringJoiner.add(option.getOptionTypeValue()+"."+option.getValue()));
        return "(" + stringJoiner + ")";
    }
}
