package com.summerdev.back.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCurrencyRequest {
    @ApiModelProperty(example = "RUB")
    private final String currencyTypeFrom;

    @ApiModelProperty(example = "EUR")
    private final String currencyTypeTo;

    @ApiModelProperty(example = "500")
    private final long currencyValueFrom;
}
