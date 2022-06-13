package com.ratz.bookservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String author;

  @Temporal(TemporalType.DATE)
  private Date launchDate;
  private Double price;
  private String title;

  @Transient
  private String currency;

  @Transient
  private String environment;


  public Book(Long id, String author, Date launchDate, Double price, String title, String currency, String environment) {
    this.id = id;
    this.author = author;
    this.launchDate = launchDate;
    this.price = price;
    this.title = title;
    this.currency = currency;
    this.environment = environment;
  }

  public Book() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(Date launchDate) {
    this.launchDate = launchDate;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getEnvironement() {
    return environment;
  }

  public void setEnvironement(String environement) {
    this.environment = environement;
  }
}
