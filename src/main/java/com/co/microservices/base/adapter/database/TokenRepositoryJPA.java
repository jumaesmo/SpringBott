package com.co.microservices.base.adapter.database;
import org.springframework.data.jpa.repository.JpaRepository;
import com.co.microservices.base.adapter.database.model.TokenEntity;

public interface TokenRepositoryJPA extends JpaRepository<TokenEntity, Integer> {

}
