package rest.koios.client.backend.factory.options;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Options
 */
@Getter
public class Options {

    private final List<Option> options;

    /**
     * Options Default Constructor
     */
    public Options() {
        options = new ArrayList<>();
    }

    /**
     * Options Constructor
     *
     * @param options list of options
     */
    public Options(List<Option> options) {
        this.options = options;
    }

    /**
     * Options List to Map
     * @return Map of Options
     */
    public Map<String, String> toMap() {
        return options.stream().collect(Collectors.toMap(Option::getOptionTypeValue, Option::getValue));
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
