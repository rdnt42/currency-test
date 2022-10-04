package com.summerdev.back.controller;

import com.summerdev.back.entity.PersonProfile;
import com.summerdev.back.service.PersonProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/web/")
@RestController
public class PersonProfileController {
    private final PersonProfileService personProfileService;

    @GetMapping("/profile")
    public PersonProfile get() {
        return personProfileService.getPersonProfile();
    }
}
