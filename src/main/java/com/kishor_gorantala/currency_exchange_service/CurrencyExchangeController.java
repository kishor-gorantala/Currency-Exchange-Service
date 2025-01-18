package com.kishor_gorantala.currency_exchange_service;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}" )
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        CurrencyExchange currencyExchange = repository.FindByFromAndTo(from, to);

        if(currencyExchange==null){
            throw new RuntimeException("Exchange not found");
        }

        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
        //return new CurrencyExchange(1000,"USD","INR", BigDecimal.valueOf(50),environment.getProperty("local.server.port"));
    }
}
