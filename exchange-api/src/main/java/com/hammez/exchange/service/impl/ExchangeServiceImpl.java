package com.hammez.exchange.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hammez.exchange.model.PairConversion;
import com.hammez.exchange.service.ExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private static final Logger LOG = LoggerFactory.getLogger(ExchangeServiceImpl.class);

    @Value("${exchange.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ExchangeServiceImpl() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
    }

    @Override
    public BigDecimal pairConversion(String baseCurrency, String targetCurrency, String amount) {
        PairConversion pairConversion = getConversionRate(baseCurrency, targetCurrency);
        return convertCurrency(new BigDecimal(amount), pairConversion.getConversionRate());
    }

    private PairConversion getConversionRate(String baseCurrency, String targetCurrency) {
        // Create our api call with key, base and target
        String pairEndpoint = String.format(
                "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                apiKey,
                baseCurrency,
                targetCurrency
        );
        ResponseEntity<String> jsonResponse = restTemplate.getForEntity(pairEndpoint, String.class);
        PairConversion pair = null;
        try {
            pair = objectMapper.readValue(jsonResponse.getBody(), PairConversion.class);
            LOG.info("Pair retrieved: " + pair.toString());
        }
        catch (JsonProcessingException e) {
            LOG.error("Error processing json into pair object", e);
        }
        return pair;
    }

    private BigDecimal convertCurrency(BigDecimal amount, BigDecimal conversionRate) {
        return amount.multiply(conversionRate);
    }

}
