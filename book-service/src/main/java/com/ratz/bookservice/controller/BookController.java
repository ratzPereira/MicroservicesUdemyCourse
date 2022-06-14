package com.ratz.bookservice.controller;

import com.ratz.bookservice.model.Book;
import com.ratz.bookservice.proxy.ExchangeProxy;
import com.ratz.bookservice.repository.BookRepository;
import com.ratz.bookservice.response.Exchange;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Book API Endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {


  @Autowired
  private Environment environment;

  @Autowired
  private BookRepository repository;


  @Autowired
  private ExchangeProxy exchangeProxy;


  @Operation(summary = "Find specific book by ID")
  @GetMapping("{id}/{currency}")
  public Book findBook(@PathVariable Long id, @PathVariable String currency ){

    Book book = repository.getById(id);

    if(book == null) throw new RuntimeException("Book not found");

    Exchange exchange = exchangeProxy.getExchange(book.getPrice(), "USD", currency);

    book.setEnvironement(environment.getProperty("local.server.port"));
    book.setPrice(exchange.getConversionValue());

    return book;
  }
}







// LOGIC WITH REST TEMPLATE  bad practices


//  Book book = repository.getById(id);
//
//    if(book == null) throw new RuntimeException("Book not found");
//
//        HashMap<String,String> params = new HashMap<>();
//    params.put("amount", book.getPrice().toString());
//    params.put("from", "USD");
//    params.put("to", currency);
//
//    ResponseEntity<Exchange> response =
//    restTemplate.getForEntity("http://localhost:8000/exchange-service/{amount}/{from}/{to}", Exchange.class, params);
//
//    Exchange exchange = response.getBody();
//    book.setEnvironement(environment.getProperty("local.server.port"));
//    book.setPrice(exchange.getConversionValue());
//
//    return book;
