package com.summerdev.back.converter;

import com.summerdev.back.entities.CurrencyType;
import com.summerdev.back.entity.Currency;
import com.summerdev.back.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CurrencyConverter {
    private final CurrencyRateService currencyRateService;

    public long convert(CurrencyType typeFrom, CurrencyType typeTo, long value) {
        Map<CurrencyType, Double> rates = currencyRateService.getRates(typeFrom);
        Double rate = rates.getOrDefault(typeTo, null);
        if (rate == null) {
            throw new NullPointerException("Rate form " + typeFrom.getName() +
                    " to " + typeTo.getName() + " cannot find");
        }

        // TODO учесть при перерасчете потерю
        return (long)(value * rate);
    }
}
