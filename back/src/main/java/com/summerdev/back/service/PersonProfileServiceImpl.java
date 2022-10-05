package com.summerdev.back.service;

import com.summerdev.back.converter.CurrencyConverter;
import com.summerdev.back.converter.PersonProfileResponseConverter;
import com.summerdev.back.entity.Currency;
import com.summerdev.back.entity.PersonProfile;
import com.summerdev.back.enums.CurrencyType;
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
        CurrencyType currencyTypeFrom = CurrencyType.getByTypeName(request.getCurrencyTypeFrom());
        long currencyValueFrom = request.getCurrencyValueFrom() * 100;

        checkCurrentBalance(currencyTypeFrom, personProfile, currencyValueFrom);

        CurrencyType currencyTypeTo = CurrencyType.getByTypeName(request.getCurrencyTypeTo());
        long currencyValueTo = currencyConverter.convert(currencyTypeFrom, currencyTypeTo, currencyValueFrom);

        decreaseBalance(personProfile, currencyTypeFrom, currencyValueFrom);
        increaseBalance(personProfile, currencyTypeTo, currencyValueTo);

        return personProfileResponseConverter.convert(personProfile);
    }

    private void increaseBalance(PersonProfile profile, CurrencyType currencyType, long value) {
        Currency currency = profile.getCurrencies().stream()
                .filter(c -> c.getCurrencyType().equals(currencyType))
                .findFirst()
                .orElseThrow();

        long newValue = currency.getCurrencyValue() + value;
        currency.setCurrencyValue(newValue);
    }

    private void decreaseBalance(PersonProfile profile, CurrencyType currencyType, long value) {
        Currency currency = profile.getCurrencies().stream()
                .filter(c -> c.getCurrencyType().equals(currencyType))
                .findFirst()
                .orElseThrow();

        long newValue = currency.getCurrencyValue() - value;
        currency.setCurrencyValue(newValue);
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
