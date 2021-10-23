package com.hammez.exchange.controller;

import com.hammez.exchange.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@CrossOrigin(origins = "*")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getCurrencies() {
        List<String> currencyCodes = currencyService.getCountryCodes();
        return new ResponseEntity<>(currencyCodes, HttpStatus.OK);
    }
}
