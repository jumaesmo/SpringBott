package com.co.microservices.base.adapter.api.facade;

import com.co.microservices.base.domain.InfoGeneral.request.general.InfoGeneralRequest;
import com.co.microservices.base.domain.InfoGeneral.response.TokenResponse;
import com.co.microservices.base.domain.InfoGeneral.service.InfoGeneralInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoGeneralFacade {

  static final Logger logger = Logger.getLogger(InfoGeneralFacade.class);

  @Autowired
  private InfoGeneralInfoService infoGeneralinfoService;

  public TokenResponse getInfo(InfoGeneralRequest info) {

    return infoGeneralinfoService.getInfoGeneralData(info);
  }
}
