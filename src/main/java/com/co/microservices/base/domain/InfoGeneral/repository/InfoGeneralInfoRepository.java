package com.co.microservices.base.domain.InfoGeneral.repository;

import com.co.microservices.base.domain.InfoGeneral.request.general.InfoGeneralRequest;
import com.co.microservices.base.domain.InfoGeneral.response.EntitiesResponse;
import com.co.microservices.base.domain.InfoGeneral.response.TokenResponse;
import org.apache.log4j.Logger;

public interface InfoGeneralInfoRepository {
    final static Logger logger = Logger.getLogger(InfoGeneralInfoRepository.class);

    TokenResponse getToken(InfoGeneralRequest info);
    EntitiesResponse getEntities(InfoGeneralRequest info, String token);

}
