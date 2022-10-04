package com.summerdev.back.service;

import com.summerdev.back.request.UpdateCurrencyRequest;
import com.summerdev.back.response.PersonProfileResponse;

public interface PersonProfileService {
    PersonProfileResponse getPersonProfile();

    PersonProfileResponse updateProfileCurrency(UpdateCurrencyRequest request);
}
