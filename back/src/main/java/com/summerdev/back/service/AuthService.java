package com.summerdev.back.service;

import org.springframework.security.core.Authentication;

public interface AuthService {

    String getToken(Authentication authentication);
}
