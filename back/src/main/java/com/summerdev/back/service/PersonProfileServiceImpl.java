package com.summerdev.back.service;

import com.summerdev.back.converter.CurrencyConverter;
import com.summerdev.back.converter.PersonProfileResponseConverter;
import com.summerdev.back.entities.CurrencyType;
import com.summerdev.back.entity.Currency;
import com.summerdev.back.entity.PersonProfile;
import com.summerdev.back.repository.PersonProfileRepository;
import com.summerdev.back.request.UpdateCurrencyRequest;
import com.summerdev.back.response.PersonProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonProfileServiceImpl implements PersonProfileService {
    private final PersonProfileRepository personProfileRepository;
    private final CurrencyConverter currencyConverter;
    private final PersonProfileResponseConverter personProfileResponseConverter;

    @Override
    public PersonProfileResponse getPersonProfile() {
        PersonProfile personProfile = personProfileRepository.getPersonProfile();
        return personProfileResponseConverter.convert(personProfile);
    }

    // TODO разнести по сервисам
    @Override
    public PersonProfileResponse updateProfileCurrency(UpdateCurrencyRequest request) {
        PersonProfile personProfile = personProfileRepository.getPersonProfile();
        CurrencyType currencyTypeFrom = CurrencyType.getById(request.getCurrencyTypeIdFrom());
        long currencyValueFrom = request.getCurrencyValueFrom() * 100;

        checkCurrentBalance(currencyTypeFrom, personProfile, currencyValueFrom);

        CurrencyType currencyTypeTo = CurrencyType.getById(request.getCurrencyTypeIdTo());
        long currencyValueTo = currencyConverter.convert(currencyTypeFrom, currencyTypeTo, currencyValueFrom);

        updatePersonProfileCurrency(personProfile, currencyTypeFrom, currencyValueFrom);
        updatePersonProfileCurrency(personProfile, currencyTypeTo, currencyValueTo);

        return personProfileResponseConverter.convert(personProfile);
    }

    private void updatePersonProfileCurrency(PersonProfile profile, CurrencyType currencyType, long newValue) {
        Currency currency = profile.getCurrencies().stream()
                .filter(c -> c.getCurrencyType().equals(currencyType))
                .findFirst()
                .orElse(null);

        // TODO переделать в мапу
        if (currency == null) {
            currency = new Currency(currencyType, newValue);
            profile.getCurrencies().add(currency);
        } else {
            currency.setCurrencyValue(newValue);
        }
    }

    private void checkCurrentBalance(CurrencyType checkedCurrency, PersonProfile profile, long checkedValue) {
        Currency currency = profile.getCurrencies().stream()
                .filter(c -> c.getCurrencyType().equals(checkedCurrency))
                .findFirst()
                .orElseThrow();

        if (currency.getCurrencyValue() < checkedValue) {
            throw new IllegalStateException("Value for exchange less then current value");
        }
    }
}
