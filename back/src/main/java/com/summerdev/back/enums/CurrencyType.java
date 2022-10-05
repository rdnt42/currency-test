package com.summerdev.back.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CurrencyType {
    CURRENCY_NAME_RUB("RUB"),
    CURRENCY_NAME_EUR("EUR"),
    CURRENCY_NAME_USD("USD"),
    CURRENCY_NAME_AMD("AMD");

    private final String typeName;

    public static CurrencyType getByTypeName(String typeName) {
        return Arrays.stream(CurrencyType.values())
                .filter(c -> c.typeName.equals(typeName))
                .findFirst()
                .orElseThrow();
    }
}
