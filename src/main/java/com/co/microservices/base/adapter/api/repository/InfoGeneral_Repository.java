package com.co.microservices.base.adapter.api.repository;

import com.co.microservices.base.domain.InfoGeneral.repository.InfoGeneralInfoRepository;
import com.co.microservices.base.domain.InfoGeneral.request.entities.EntitiesRequest;
import com.co.microservices.base.domain.InfoGeneral.request.general.Contacts;
import com.co.microservices.base.domain.InfoGeneral.request.general.InfoGeneralRequest;
import com.co.microservices.base.domain.InfoGeneral.request.token.TokenRequest;
import com.co.microservices.base.domain.InfoGeneral.response.EntitiesResponse;
import com.co.microservices.base.domain.InfoGeneral.response.TokenResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InfoGeneral_Repository implements InfoGeneralInfoRepository {

  static final Logger logger = Logger.getLogger(InfoGeneral_Repository.class);
  private RestTemplate restTemplate;
  private ObjectMapper objectMapper;
  private DozerBeanMapper dozerBeanMapper;
  @Value("${urlToken}")
  private String url;

  @Autowired
  public InfoGeneral_Repository(
    RestTemplate restTemplate,
    ObjectMapper objectMapper,
    DozerBeanMapper dozerBeanMapper
  ) {
    this.dozerBeanMapper = dozerBeanMapper;
    this.restTemplate = restTemplate;
    this.objectMapper = objectMapper;
  }

  @Override
  public TokenResponse getToken(InfoGeneralRequest info) {
    HttpHeaders headers = new HttpHeaders();
    TokenRequest tokenRequest =  dozerBeanMapper.map(info.getUser(), TokenRequest.class, "token-map" );
    HttpEntity<TokenRequest> request = new HttpEntity<>(tokenRequest, headers);
    ResponseEntity<String> result = this.restTemplate.postForEntity(url+"token", request, String.class);

    return objectMapper.convertValue(
            result.getBody(),
            TokenResponse.class
    );
  }

  @Override
  public EntitiesResponse getEntities(InfoGeneralRequest info,String token) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", token );
    headers.set("accept", "application/json" );
    headers.set("Content-Type", "application/json" );
    EntitiesRequest entitiesRequest =  new EntitiesRequest();

    entitiesRequest.setEntityTypeId(info.getEntityTypeId());
    List<Contacts> contacts = info.getContacts().stream().filter(contacts1 -> contacts1.isCallbackReferent()).collect(Collectors.toList());
    entitiesRequest.setContacts(contacts);
    entitiesRequest.setFields(info.getFields());
    entitiesRequest.setLinkedEntitiesIds(info.getLinkedEntitiesIds());

    HttpEntity<EntitiesRequest> request = new HttpEntity<>(entitiesRequest, headers);
    ResponseEntity<String> result = this.restTemplate.postForEntity(url+"entities/create_with_data", request, String.class);

    return objectMapper.convertValue(
            result.getBody(),
            EntitiesResponse.class
    );
  }


}
