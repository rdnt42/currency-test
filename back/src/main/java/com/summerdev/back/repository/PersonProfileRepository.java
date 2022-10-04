package com.summerdev.back.repository;

import com.summerdev.back.entities.CurrencyType;
import com.summerdev.back.entity.Currency;
import com.summerdev.back.entity.PersonProfile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
public class PersonProfileRepository {
    private PersonProfile personProfile;

    @PostConstruct
    private void init() {
        Currency currency = new Currency(CurrencyType.CURRENCY_NAME_RUB, 100000);
        personProfile = PersonProfile
                .builder()
                .currencies(Collections.singletonList(currency))
                .build();
    }

    public PersonProfile getPersonProfile() {
        return personProfile;
    }
}
