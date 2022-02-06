package com.co.microservices.base.adapter.api.repository;

import com.co.microservices.base.domain.InfoGeneral.repository.InfoGeneralInfoRepository;
import com.co.microservices.base.domain.InfoGeneral.request.cases.CasesRequest;
import com.co.microservices.base.domain.InfoGeneral.request.entities.Contacts;
import com.co.microservices.base.domain.InfoGeneral.request.entities.EntitiesRequest;
import com.co.microservices.base.domain.InfoGeneral.request.general.InfoGeneralRequest;
import com.co.microservices.base.domain.InfoGeneral.request.token.TokenRequest;
import com.co.microservices.base.domain.InfoGeneral.response.EntitiesResponse;
import com.co.microservices.base.domain.InfoGeneral.response.TokenResponse;
import com.co.microservices.base.domain.InfoGeneral.response.cases.CasesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class InfoGeneral_Repository implements InfoGeneralInfoRepository {

  static final Logger logger = Logger.getLogger(InfoGeneral_Repository.class);
  private RestTemplate restTemplate;
  private ObjectMapper objectMapper;

  @Value("${urlToken}")
  private String url;

  @Autowired
  public InfoGeneral_Repository(
    RestTemplate restTemplate,
    ObjectMapper objectMapper,
    DozerBeanMapper dozerBeanMapper
  ) {
    this.restTemplate = restTemplate;
    this.objectMapper = objectMapper;
  }

  @Override
  public TokenResponse getToken(InfoGeneralRequest info) {
    HttpHeaders headers = new HttpHeaders();
    TokenRequest tokenRequest = info.getUser();
    HttpEntity<TokenRequest> request = new HttpEntity<>(tokenRequest, headers);
    ResponseEntity<String> result =
      this.restTemplate.postForEntity(url + "token", request, String.class);
    String responseBody = result.getBody();
    return new Gson().fromJson(responseBody, TokenResponse.class);
  }

  @Override
  public EntitiesResponse getEntities(InfoGeneralRequest info, String token) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", token);
    headers.set("accept", "application/json");
    headers.set("Content-Type", "application/json");
    EntitiesRequest entitiesRequest = new EntitiesRequest();

    entitiesRequest.setEntityTypeId(info.getEntities().getEntityTypeId());
    List<Contacts> contacts = info
      .getEntities()
      .getContacts()
      .stream()
      .filter(contacts1 -> contacts1.isCallbackReferent())
      .collect(Collectors.toList());
    entitiesRequest.setContacts(contacts);
    entitiesRequest.setFields(info.getEntities().getFields());
    entitiesRequest.setLinkedEntitiesIds(
      info.getEntities().getLinkedEntitiesIds()
    );

    HttpEntity<EntitiesRequest> request = new HttpEntity<>(
      entitiesRequest,
      headers
    );
    ResponseEntity<String> result =
      this.restTemplate.postForEntity(
          url + "entities/create_with_data",
          request,
          String.class
        );

    return objectMapper.convertValue(result.getBody(), EntitiesResponse.class);
  }

  @Override
  public CasesResponse getCases(InfoGeneralRequest info, String token) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", token);
    headers.set("accept", "application/json");
    headers.set("Content-Type", "application/json");
    CasesRequest casesRequest = new CasesRequest();


    return null;
  }
}
