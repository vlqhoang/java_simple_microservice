package com.practice.microservice.currencycalculationservice.controller;

import com.practice.microservice.currencycalculationservice.dto.CurrencyConversionDTO;
import com.practice.microservice.currencycalculationservice.feign.CurrencyExchangeServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyCalculationController {

    @Autowired
    private CurrencyExchangeServiceFeign currencyExchangeFeign;

    @GetMapping("/currency-calculation/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDTO convertCurrency(@PathVariable String from,
                                                 @PathVariable String to,
                                                 @PathVariable BigDecimal quantity) {

        CurrencyConversionDTO response = currencyExchangeFeign.retrieveExchangeValue(from, to);
        if (response == null) response = new CurrencyConversionDTO();
        response.setQuantity(quantity);
        response.setTotalCalculatedAmount(quantity.multiply(response.getConversionMultiple()));
        return response;
    }
}
