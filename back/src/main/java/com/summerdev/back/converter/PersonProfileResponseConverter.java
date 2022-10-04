package com.summerdev.back.converter;

import com.summerdev.back.entity.Currency;
import com.summerdev.back.entity.PersonProfile;
import com.summerdev.back.response.PersonProfileResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonProfileResponseConverter {
    public PersonProfileResponse convert(PersonProfile profile) {
        Map<String, String> currencies = new HashMap<>();

        for (Currency currency : profile.getCurrencies()) {
            String formatValue = String.format("%.2f", (currency.getCurrencyValue() / 100.0));
            currencies.put(currency.getCurrencyType().getName(), formatValue);
        }

        return PersonProfileResponse
                .builder()
                .currencies(currencies)
                .build();
    }
}
