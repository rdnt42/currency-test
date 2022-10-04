package com.summerdev.back.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Builder
public class PersonProfileResponse implements Serializable {
    private final Map<String, String> currencies;
}
