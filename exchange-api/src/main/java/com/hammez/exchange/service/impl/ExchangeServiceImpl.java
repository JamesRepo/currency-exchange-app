package com.hammez.exchange.service.impl;

import com.hammez.exchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Value("${exchange.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public ExchangeServiceImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public void convertCurrencyToAll(String currency) {}

    @Override
    public void pairConversion(String baseCurrency, String targetCurrency) {
        // Create our api call with key, base and target
        String pairEndpoint = String.format(
                "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                apiKey,
                baseCurrency,
                targetCurrency
        );
        ResponseEntity<String> jsonResponse = restTemplate.getForEntity(pairEndpoint, String.class);
        System.out.println(jsonResponse);
    }

}
