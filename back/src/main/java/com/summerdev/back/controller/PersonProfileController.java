package com.summerdev.back.controller;

import com.summerdev.back.request.UpdateCurrencyRequest;
import com.summerdev.back.response.PersonProfileResponse;
import com.summerdev.back.service.PersonProfileService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/web")
@RestController
public class PersonProfileController {
    private final PersonProfileService personProfileService;

    @ApiOperation(value = "Получить сведения о портфеле пользователя", notes = "Получить сведения о портфеле пользователя")
    @GetMapping("/profile")
    public PersonProfileResponse get() {
        return personProfileService.getPersonProfile();
    }

    @ApiOperation(value = "Конвертировать валюту", notes = "Конвертировать валюту")
    @ApiImplicitParam(name = "request", value = "Параметры конвертации валюты", required = true, dataType = "UpdateCurrencyRequest")
    @PostMapping("/profile/convertCurrency")
    public PersonProfileResponse convertCurrency(@RequestBody UpdateCurrencyRequest request) {
        return personProfileService.updateProfileCurrency(request);
    }
}
