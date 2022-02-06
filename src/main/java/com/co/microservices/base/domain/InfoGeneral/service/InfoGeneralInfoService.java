package com.co.microservices.base.domain.InfoGeneral.service;

import com.co.microservices.base.domain.InfoGeneral.repository.InfoGeneralInfoRepository;
import com.co.microservices.base.domain.InfoGeneral.request.general.InfoGeneralRequest;
import com.co.microservices.base.domain.InfoGeneral.response.EntitiesResponse;
import com.co.microservices.base.domain.InfoGeneral.response.TokenResponse;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfoGeneralInfoService {
    final static Logger logger = Logger.getLogger(InfoGeneralInfoService.class);
    private InfoGeneralInfoRepository informationGeneralinfoRepository;
    private DozerBeanMapper mapper;


    @Autowired
    public InfoGeneralInfoService(InfoGeneralInfoRepository informationGeneralinfoRepository, DozerBeanMapper mapper){
        this.informationGeneralinfoRepository = informationGeneralinfoRepository;
        this.mapper = mapper;
    }

    public TokenResponse getInfoGeneralData(InfoGeneralRequest info) {
        TokenResponse tokenResponse = informationGeneralinfoRepository.getToken(info);
        EntitiesResponse entitiesResponse = informationGeneralinfoRepository.getEntities(info,tokenResponse.getToken());
        return tokenResponse;
    }

}
