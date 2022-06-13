package com.ratz.bookservice.controller;

import com.ratz.bookservice.model.Book;
import com.ratz.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {


  @Autowired
  private Environment environment;

  @Autowired
  private BookRepository repository;


  @GetMapping("{id}/{currency}")
  public Book findBook(@PathVariable Long id, @PathVariable String currency ){

    Book book = repository.getById(id);

    if(book == null) throw new RuntimeException("Book not found");

    book.setEnvironement(environment.getProperty("local.server.port"));

    return book;
  }
}
