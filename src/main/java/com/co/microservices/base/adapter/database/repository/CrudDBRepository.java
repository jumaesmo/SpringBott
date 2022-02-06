package com.co.microservices.base.adapter.database.repository;

import com.co.microservices.base.adapter.database.TokenRepositoryJPA;
import com.co.microservices.base.adapter.database.model.TokenEntity;
import com.co.microservices.base.domain.InfoGeneral.repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrudDBRepository implements CRUDRepository {
    private final TokenRepositoryJPA tokenRepositoryJPA;

    @Autowired
    public CrudDBRepository(TokenRepositoryJPA loginRepositoryJPA) {
        this.tokenRepositoryJPA = loginRepositoryJPA;
    }

    @Override
    public void saveToken(String token) {
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setToken(token);
        this.tokenRepositoryJPA.save(tokenEntity);
    }
}
