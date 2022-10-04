package com.summerdev.back.service;

import com.summerdev.back.entities.CurrencyType;

import java.util.Map;

public interface CurrencyRateService {
    // TODO Mock service
    Map<CurrencyType, Double> getRates(CurrencyType typeFor);
}
