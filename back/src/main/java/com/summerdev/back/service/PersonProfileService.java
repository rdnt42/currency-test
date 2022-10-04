package com.summerdev.back.service;

import com.summerdev.back.entity.PersonProfile;
import com.summerdev.back.request.UpdateCurrencyRequest;

public interface PersonProfileService {
    PersonProfile getPersonProfile();

    // TODO разнести по сервисам
    PersonProfile updateProfileCurrency(UpdateCurrencyRequest request);
}
