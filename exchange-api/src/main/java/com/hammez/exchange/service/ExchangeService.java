package com.hammez.exchange.service;

public interface ExchangeService {

    void convertCurrencyToAll(String currency);

    void pairConversion(String baseCurrency, String targetCurrency);

}
