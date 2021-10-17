package com.hammez.exchange.service;

import java.math.BigDecimal;

public interface ExchangeService {

    void convertCurrencyToAll(String currency);

    BigDecimal pairConversion(String baseCurrency, String targetCurrency, String amount);

}
