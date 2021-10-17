package com.hammez.exchange.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PairConversion {

    private String baseCode;
    private String targetCode;
    private BigDecimal conversionRate;

    @JsonProperty("base_code")
    private void baseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    @JsonProperty("target_code")
    private void targetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    @JsonProperty("conversion_rate")
    private void conversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

}
