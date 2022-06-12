package com.ratz.exchangerateservice.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Exchange implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "from_currency", length = 3, nullable = false)
  private String from;

  @Column(name = "to_currency")
  private String to;

  @Column(nullable = false)
  private BigDecimal conversionFactor;

  @Transient
  private BigDecimal convertedValue;

  @Transient
  private String environment;

  public Exchange(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue, String environment) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionFactor = conversionFactor;
    this.convertedValue = convertedValue;
    this.environment = environment;
  }

  public Exchange() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigDecimal getConversionFactor() {
    return conversionFactor;
  }

  public void setConversionFactor(BigDecimal conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public BigDecimal getConversionValue() {
    return convertedValue;
  }

  public void setConversionValue(BigDecimal conversionValue) {
    this.convertedValue = conversionValue;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }
}
