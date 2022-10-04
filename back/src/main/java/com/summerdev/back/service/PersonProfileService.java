package com.summerdev.back.service;

import com.summerdev.back.entity.PersonProfile;
import com.summerdev.back.request.UpdateCurrencyRequest;
import com.summerdev.back.response.PersonProfileResponse;

public interface PersonProfileService {
    PersonProfileResponse getPersonProfile();

    // TODO разнести по сервисам
    PersonProfile updateProfileCurrency(UpdateCurrencyRequest request);
}
