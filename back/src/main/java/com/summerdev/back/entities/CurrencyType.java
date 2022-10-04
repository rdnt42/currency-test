package com.summerdev.back.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CurrencyType {
    CURRENCY_NAME_RUB(1, "RUB"),
    CURRENCY_NAME_EUR(2, "EUR"),
    CURRENCY_NAME_USD(3, "USD"),
    CURRENCY_NAME_AMD(4, "AMD");

    private final int id;
    private final String name;

    public static CurrencyType getById(int id) {
        return Arrays.stream(CurrencyType.values())
                .filter(c -> c.id == id)
                .findFirst()
                .orElseThrow();
    }
}
