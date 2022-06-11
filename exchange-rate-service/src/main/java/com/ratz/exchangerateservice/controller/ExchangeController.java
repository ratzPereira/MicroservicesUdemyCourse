package com.ratz.exchangerateservice.controller;


import com.ratz.exchangerateservice.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("exchange-service")
public class ExchangeController {

  @Autowired
  private Environment environment;


  @GetMapping("/{amount}/{from}/{to}")
  public Exchange getExchange(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to){

    String port = environment.getProperty("local.server.port");

    return new Exchange(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, port);
  }
}
