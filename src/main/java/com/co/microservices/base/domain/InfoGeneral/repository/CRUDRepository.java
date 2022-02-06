package com.co.microservices.base.domain.InfoGeneral.repository;

import org.springframework.stereotype.Component;

@Component
public interface CRUDRepository {
   void saveToken(String token);
}
