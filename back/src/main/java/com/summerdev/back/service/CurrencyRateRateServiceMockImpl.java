package com.summerdev.back.service;

import com.summerdev.back.enums.CurrencyType;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

@Service("currencyServiceMock")
public class CurrencyRateRateServiceMockImpl implements CurrencyRateService {

    // TODO Mock service
    @Override
    public Map<CurrencyType, Double> getRates(CurrencyType typeFor) {
        Map<CurrencyType, Double> result = new EnumMap<>(CurrencyType.class);
        switch (typeFor) {
            case CURRENCY_NAME_RUB:
                result = getRubRates();
                break;
            case CURRENCY_NAME_USD:
                result = getUsdRates();
                break;
            case CURRENCY_NAME_EUR:
                result = getEurRates();
                break;
            case CURRENCY_NAME_AMD:
                result = getAmdRates();
                break;
        }

        return result;
    }

    private Map<CurrencyType, Double> getRubRates() {
        Map<CurrencyType, Double> map = new EnumMap<>(CurrencyType.class);
        map.put(CurrencyType.CURRENCY_NAME_EUR, 0.017);
        map.put(CurrencyType.CURRENCY_NAME_USD, 0.017);
        map.put(CurrencyType.CURRENCY_NAME_AMD, 6.89);

        return map;
    }

    private Map<CurrencyType, Double> getEurRates() {
        Map<CurrencyType, Double> map = new EnumMap<>(CurrencyType.class);
        map.put(CurrencyType.CURRENCY_NAME_RUB, 58.66);
        map.put(CurrencyType.CURRENCY_NAME_USD, 0.99);
        map.put(CurrencyType.CURRENCY_NAME_AMD, 404.22);

        return map;
    }

    private Map<CurrencyType, Double> getUsdRates() {
        Map<CurrencyType, Double> map = new EnumMap<>(CurrencyType.class);
        map.put(CurrencyType.CURRENCY_NAME_RUB, 59.03);
        map.put(CurrencyType.CURRENCY_NAME_EUR, 1.01);
        map.put(CurrencyType.CURRENCY_NAME_AMD, 406.49);

        return map;
    }

    private Map<CurrencyType, Double> getAmdRates() {
        Map<CurrencyType, Double> map = new EnumMap<>(CurrencyType.class);
        map.put(CurrencyType.CURRENCY_NAME_RUB, 0.015);
        map.put(CurrencyType.CURRENCY_NAME_USD, 0.025);
        map.put(CurrencyType.CURRENCY_NAME_EUR, 0.0025);

        return map;
    }
}
