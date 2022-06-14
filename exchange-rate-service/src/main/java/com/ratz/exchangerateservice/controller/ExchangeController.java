package com.ratz.exchangerateservice.controller;


import com.ratz.exchangerateservice.model.Exchange;
import com.ratz.exchangerateservice.repository.ExchangeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Tag(name = "Exchange Service API")
@RestController
@RequestMapping("exchange-service")
public class ExchangeController {

  @Autowired
  private Environment environment;

  @Autowired
  private ExchangeRepository repository;


  @Operation(description = "Get Exchange from currency")
  @GetMapping("/{amount}/{from}/{to}")
  public Exchange getExchange(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to){



    Exchange exchange = repository.findByFromAndTo(from, to);

    if(exchange == null) throw  new RuntimeException("Currency Unsupported");

    String port = environment.getProperty("local.server.port");
    exchange.setEnvironment(port);

    BigDecimal conversionFactor = exchange.getConversionFactor();
    BigDecimal convertedValue = conversionFactor.multiply(amount);
    exchange.setConversionValue(convertedValue.setScale(2, RoundingMode.CEILING));

    return exchange;
  }
}
