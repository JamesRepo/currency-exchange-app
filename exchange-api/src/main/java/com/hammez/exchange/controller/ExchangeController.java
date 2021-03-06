package com.hammez.exchange.controller;

import com.hammez.exchange.service.ExchangeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/exchange")
@CrossOrigin(origins = "*")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @RequestMapping(value = "/pair", method = RequestMethod.GET)
    public ResponseEntity<BigDecimal> doPairConversion(
            @RequestParam String base,
            @RequestParam String target,
            @RequestParam String amount
    ) {
        BigDecimal convertedAmount = exchangeService.pairConversion(base, target, amount);
        return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
    }



}
