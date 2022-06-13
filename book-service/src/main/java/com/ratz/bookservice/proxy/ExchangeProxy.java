package com.ratz.bookservice.proxy;


import com.ratz.bookservice.response.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "exchange-service", url = "http://localhost:8000")
public interface ExchangeProxy {


  @GetMapping("/exchange-service/{amount}/{from}/{to}")
  Exchange getExchange(@PathVariable Double amount, @PathVariable String from, @PathVariable String to);


}
