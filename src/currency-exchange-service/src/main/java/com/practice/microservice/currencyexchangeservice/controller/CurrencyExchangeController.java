package com.practice.microservice.currencyexchangeservice.controller;

import com.practice.microservice.currencyexchangeservice.model.ExchangeValue;
import com.practice.microservice.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from,
                                               @PathVariable String to) {

        ExchangeValue exchangeValue = exchangeValueRepository.findByCurrencies(from, to);
        if (exchangeValue == null) exchangeValue = new ExchangeValue();
        exchangeValue.setPort(environment.getProperty("local.server.port"));
        return exchangeValue;
    }
}
