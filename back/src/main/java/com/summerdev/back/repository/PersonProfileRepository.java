package com.summerdev.back.repository;

import com.summerdev.back.entities.CurrencyType;
import com.summerdev.back.entity.Currency;
import com.summerdev.back.entity.PersonProfile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonProfileRepository {
    private PersonProfile personProfile;

    @PostConstruct
    private void init() {
        Currency currency = new Currency(CurrencyType.CURRENCY_NAME_RUB, 100000);
        List<Currency> currencies = Stream.of(currency)
                .collect(Collectors.toList());
        personProfile = new PersonProfile(currencies);
    }

    public PersonProfile getPersonProfile() {
        return personProfile;
    }
}
