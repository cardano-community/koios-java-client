package com.reina.koios.client.backend.factory.options;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class Options {

    private final List<Option> options;

    public Options() {
        options = new ArrayList<>();
    }

    public Options(List<Option> options) {
        this.options = options;
    }

    public static OptionsBuilder builder() {
        return new OptionsBuilder();
    }

    public static class OptionsBuilder {

        private List<Option> options;

        public OptionsBuilder option(Option option) {
            if (this.options == null) {
                this.options = new ArrayList<>();
            }
            this.options.add(option);
            return this;
        }

        public OptionsBuilder options(Collection<? extends Option> options) {
            if (this.options == null) {
                this.options = new ArrayList<>();
            }
            this.options.addAll(options);
            return this;
        }

        public OptionsBuilder clearOptions() {
            if (this.options != null) {
                this.options.clear();
            }
            return this;
        }

        public Options build() {
            return new Options(options);
        }
    }
}
