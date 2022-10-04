package com.summerdev.back.entity;

import com.summerdev.back.entities.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Currency {
    private CurrencyType currencyType;
    private long currencyValue;
}
