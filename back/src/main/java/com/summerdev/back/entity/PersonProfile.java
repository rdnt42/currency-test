package com.summerdev.back.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PersonProfile {
    private List<Currency> currencies;
}
