package com.hammez.exchange.service.impl;

import com.hammez.exchange.dao.CurrencyDao;
import com.hammez.exchange.model.Currency;
import com.hammez.exchange.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyDao currencyDao;

    public CurrencyServiceImpl(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Override
    public List<String> getCountryCodes() {
        List<Currency> currencies = currencyDao.findAll();
        return currencies.stream().map(Currency::getCode).collect(Collectors.toList());
    }

}
