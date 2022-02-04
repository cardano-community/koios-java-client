package com.reina.koios.client.backend.factory.options;

import lombok.Getter;

@Getter
public class Offset extends Option {

    private final long offset;

    public Offset(long offset) {
        super(OptionType.OFFSET);
        this.offset = offset;
    }

    public static Offset of(long offset) {
        return new Offset(offset);
    }

    @Override
    public String getValue() {
        return String.valueOf(offset);
    }
}
