package com.summerdev.back.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCurrencyRequest {
    @ApiModelProperty(example = "1")
    private final int currencyTypeIdFrom;

    @ApiModelProperty(example = "2")
    private final int currencyTypeIdTo;

    @ApiModelProperty(example = "500")
    private final long currencyValueFrom;
}
