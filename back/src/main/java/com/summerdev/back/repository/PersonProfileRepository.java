package com.summerdev.back.repository;

import com.summerdev.back.entities.CurrencyType;
import com.summerdev.back.entity.Currency;
import com.summerdev.back.entity.PersonProfile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonProfileRepository {
    private PersonProfile personProfile;

    @PostConstruct
    private void init() {
        Currency currencyRub = new Currency(CurrencyType.CURRENCY_NAME_RUB, 100000);
        Currency currencyEur = new Currency(CurrencyType.CURRENCY_NAME_EUR, 0);
        Currency currencyUsd = new Currency(CurrencyType.CURRENCY_NAME_USD, 0);
        Currency currencyAmd = new Currency(CurrencyType.CURRENCY_NAME_AMD, 0);
        List<Currency> currencies = Stream.of(currencyRub, currencyEur, currencyUsd, currencyAmd)
                .collect(Collectors.toList());
        personProfile = new PersonProfile(currencies);
    }

    public PersonProfile getPersonProfile() {
        return personProfile;
    }
}
