package com.reina.koios.client.backend.factory.options;

import lombok.Getter;

@Getter
public abstract class Option {

    private final OptionType optionType;

    public Option(OptionType optionType) {
        this.optionType = optionType;
    }

    public abstract String getValue();
}
