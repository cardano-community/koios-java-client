package com.reina.koios.client.backend.factory.options;

import lombok.Getter;

@Getter
public class Limit extends Option {

    private final long limit;

    public Limit(long limit) {
        super(OptionType.LIMIT);
        this.limit = limit;
    }

    public static Limit of(long limit) {
        return new Limit(limit);
    }

    @Override
    public String getValue() {
        return String.valueOf(limit);
    }
}
