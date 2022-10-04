package com.summerdev.back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class PersonProfile {
    private List<Currency> currencies;
}
