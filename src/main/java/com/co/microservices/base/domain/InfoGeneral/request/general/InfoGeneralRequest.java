package com.co.microservices.base.domain.InfoGeneral.request.general;

import com.co.microservices.base.domain.InfoGeneral.request.cases.CasesRequest;
import com.co.microservices.base.domain.InfoGeneral.request.entities.EntitiesRequest;
import com.co.microservices.base.domain.InfoGeneral.request.token.TokenRequest;

public class InfoGeneralRequest {

  private EntitiesRequest entities;
  private CasesRequest casesRequest;
  private TokenRequest user;

  public EntitiesRequest getEntities() {
    return entities;
  }

  public void setEntities(EntitiesRequest entities) {
    this.entities = entities;
  }

  public CasesRequest getCasesRequest() {
    return casesRequest;
  }

  public void setCasesRequest(CasesRequest casesRequest) {
    this.casesRequest = casesRequest;
  }

  public TokenRequest getUser() {
    return user;
  }

  public void setUser(TokenRequest user) {
    this.user = user;
  }
}
