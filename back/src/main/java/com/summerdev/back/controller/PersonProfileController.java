package com.summerdev.back.controller;

import com.summerdev.back.request.UpdateCurrencyRequest;
import com.summerdev.back.response.PersonProfileResponse;
import com.summerdev.back.service.PersonProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("api/web/")
@RestController
public class PersonProfileController {
    private final PersonProfileService personProfileService;

    @GetMapping("/profile")
    public PersonProfileResponse get() {
        return personProfileService.getPersonProfile();
    }

    @PostMapping("/profile/convertCurrency")
    public PersonProfileResponse convertCurrency(@RequestBody UpdateCurrencyRequest request) {
        return personProfileService.updateProfileCurrency(request);
    }
}
