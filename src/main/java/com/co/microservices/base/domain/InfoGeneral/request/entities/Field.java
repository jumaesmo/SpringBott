package com.co.microservices.base.domain.InfoGeneral.request.entities;

public class Field {

  public int mapperId;
  public String value;

  public int getMapperId() {
    return mapperId;
  }

  public void setMapperId(int mapperId) {
    this.mapperId = mapperId;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
