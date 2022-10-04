package com.summerdev.back.service;

import com.summerdev.back.entities.CurrencyType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("currencyServiceMock")
public class CurrencyRateRateServiceMockImpl implements CurrencyRateService {

    // TODO Mock service
    @Override
    public Map<CurrencyType, Double> getRates(CurrencyType typeFor) {
        Map<CurrencyType, Double> result = new HashMap<>();
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
        Map<CurrencyType, Double> map = new HashMap<>();
        map.put(CurrencyType.CURRENCY_NAME_EUR, 0.01538);
        map.put(CurrencyType.CURRENCY_NAME_USD, 0.01587);
        map.put(CurrencyType.CURRENCY_NAME_AMD, 0.01464);

        return map;
    }

    private Map<CurrencyType, Double> getEurRates() {
        Map<CurrencyType, Double> map = new HashMap<>();
        map.put(CurrencyType.CURRENCY_NAME_RUB, 0.01538);
        map.put(CurrencyType.CURRENCY_NAME_USD, 0.01587);
        map.put(CurrencyType.CURRENCY_NAME_AMD, 0.01464);

        return map;
    }

    private Map<CurrencyType, Double> getUsdRates() {
        Map<CurrencyType, Double> map = new HashMap<>();
        map.put(CurrencyType.CURRENCY_NAME_RUB, 0.01538);
        map.put(CurrencyType.CURRENCY_NAME_EUR, 0.01587);
        map.put(CurrencyType.CURRENCY_NAME_AMD, 0.01464);

        return map;
    }

    private Map<CurrencyType, Double> getAmdRates() {
        Map<CurrencyType, Double> map = new HashMap<>();
        map.put(CurrencyType.CURRENCY_NAME_RUB, 0.01538);
        map.put(CurrencyType.CURRENCY_NAME_USD, 0.01587);
        map.put(CurrencyType.CURRENCY_NAME_EUR, 0.01464);

        return map;
    }
}
