package rest.koios.client.backend.factory.options;

import lombok.Getter;
import rest.koios.client.backend.factory.options.filters.LogicalOperatorFilter;
import rest.koios.client.backend.factory.options.filters.LogicalOperatorFilterType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Options
 */
@Getter
public class Options {

    private final List<Option> optionList;
    public static final Options EMPTY = null;

    /**
     * Options Default Constructor
     */
    public Options() {
        optionList = new ArrayList<>();
    }

    /**
     * Options Constructor
     *
     * @param optionList list of options
     */
    public Options(List<Option> optionList) {
        this.optionList = optionList;
    }

    /**
     * Options List to Map
     *
     * @return Map of Options
     */
    public Map<String, String> toMap() {
        List<Option> optionArrayList = new ArrayList<>();
        List<Option> filters = new ArrayList<>();
        for (Option option : this.optionList) {
            if (option.getOptionType() == OptionType.FILTER) {
                filters.add(option);
            } else {
                optionArrayList.add(option);
            }
        }
        if (filters.size() >= 2) {
            optionArrayList.add(LogicalOperatorFilter.of(LogicalOperatorFilterType.AND,filters.toArray(new Option[0])));
        } else if (filters.size() == 1) {
            optionArrayList.add(filters.get(0));
        }
        return optionArrayList.stream().collect(Collectors.toMap(Option::getOptionTypeValue, Option::getValue));
    }

    /**
     * OptionsBuilder.builder
     *
     * @return new OptionsBuilder
     */
    public static OptionsBuilder builder() {
        return new OptionsBuilder();
    }

    /**
     * Options Builder
     */
    public static class OptionsBuilder {

        private List<Option> options;

        /**
         * option
         * Add new Option to OptionBuilder
         *
         * @param option option to add
         * @return OptionsBuilder
         */
        public OptionsBuilder option(Option option) {
            if (this.options == null) {
                this.options = new ArrayList<>();
            }
            this.options.add(option);
            return this;
        }

        /**
         * options
         * Add new Options to OptionBuilder
         *
         * @param options options to add
         * @return OptionsBuilder
         */
        public OptionsBuilder options(Collection<? extends Option> options) {
            if (this.options == null) {
                this.options = new ArrayList<>();
            }
            this.options.addAll(options);
            return this;
        }

        /**
         * Build OptionsBuilder Object
         *
         * @return Options
         */
        public Options build() {
            return new Options(options);
        }
    }
}
