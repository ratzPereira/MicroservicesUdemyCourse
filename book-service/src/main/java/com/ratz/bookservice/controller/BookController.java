package com.ratz.bookservice.controller;

import com.ratz.bookservice.model.Book;
import com.ratz.bookservice.repository.BookRepository;
import com.ratz.bookservice.response.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("book-service")
public class BookController {


  @Autowired
  private Environment environment;

  @Autowired
  private BookRepository repository;

  @Autowired
  private RestTemplate restTemplate;


  @GetMapping("{id}/{currency}")
  public Book findBook(@PathVariable Long id, @PathVariable String currency ){

    Book book = repository.getById(id);

    if(book == null) throw new RuntimeException("Book not found");

    HashMap<String,String> params = new HashMap<>();
    params.put("amount", book.getPrice().toString());
    params.put("from", "USD");
    params.put("to", currency);

    ResponseEntity<Exchange> response =
        restTemplate.getForEntity("http://localhost:8000/exchange-service/{amount}/{from}/{to}", Exchange.class, params);

    Exchange exchange = response.getBody();
    book.setEnvironement(environment.getProperty("local.server.port"));
    book.setPrice(exchange.getConversionValue());

    return book;
  }
}
