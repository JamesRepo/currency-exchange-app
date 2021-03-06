package com.hammez.exchange.service;

import java.math.BigDecimal;

public interface ExchangeService {

    BigDecimal pairConversion(String baseCurrency, String targetCurrency, String amount);

}
