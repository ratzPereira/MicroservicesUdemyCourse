package com.ratz.bookservice.response;


import java.io.Serializable;
import java.math.BigDecimal;

public class Exchange implements Serializable {

  private static final long serialVersionUID = 1L;


  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionFactor;
  private Double convertedValue;
  private String environment;

  public Exchange(Long id, String from, String to, BigDecimal conversionFactor, Double convertedValue, String environment) {
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

  public Double getConversionValue() {
    return convertedValue;
  }

  public void setConversionValue(Double conversionValue) {
    this.convertedValue = conversionValue;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }
}
