package com.co.microservices.base.domain.InfoGeneral.service;

import com.co.microservices.base.domain.InfoGeneral.repository.CRUDRepository;
import com.co.microservices.base.domain.InfoGeneral.repository.InfoGeneralInfoRepository;
import com.co.microservices.base.domain.InfoGeneral.request.general.InfoGeneralRequest;
import com.co.microservices.base.domain.InfoGeneral.response.TokenResponse;
import com.co.microservices.base.domain.InfoGeneral.response.cases.CasesResponse;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfoGeneralInfoService {
    final static Logger logger = Logger.getLogger(InfoGeneralInfoService.class);
    private InfoGeneralInfoRepository informationGeneralinfoRepository;
    private DozerBeanMapper mapper;
    private CRUDRepository crudRepository;

    @Autowired
    public InfoGeneralInfoService(InfoGeneralInfoRepository informationGeneralinfoRepository, DozerBeanMapper mapper, CRUDRepository crudRepository){
        this.informationGeneralinfoRepository = informationGeneralinfoRepository;
        this.mapper = mapper;
        this.crudRepository = crudRepository;
    }

    public TokenResponse getInfoGeneralData(InfoGeneralRequest info) {
        TokenResponse tokenResponse = informationGeneralinfoRepository.getToken(info);
        this.crudRepository.saveToken(tokenResponse.getToken());
        
        // CasesResponse casesResponse = informationGeneralinfoRepository.getCases(info, tokenResponse.getToken());
        // EntitiesResponse entitiesResponse = informationGeneralinfoRepository.getEntities(info,tokenResponse.getToken());
        return tokenResponse;
    }

}
