package rest.koios.client.backend.factory.options;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
