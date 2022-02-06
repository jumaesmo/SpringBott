package com.co.microservices.base.adapter.api.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.co.microservices.base.adapter.api.ApiConst;
import com.co.microservices.base.adapter.api.facade.InfoGeneralFacade;
import com.co.microservices.base.domain.InfoGeneral.request.general.InfoGeneralRequest;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConst.JURISCOOP_PATH)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class InfoGeneralController {

  static final Logger logger = Logger.getLogger(InfoGeneralController.class);
  private InfoGeneralFacade infoGeneralfacade;

  @Autowired
  public InfoGeneralController(InfoGeneralFacade infoGeneralfacade) {
    this.infoGeneralfacade = infoGeneralfacade;
  }

  @ApiOperation(value = "InfoGeneral")
  @RequestMapping(
    value = "/InfoGeneral/",
    method = RequestMethod.POST,
    produces = APPLICATION_JSON_VALUE
  )
  public ResponseEntity<String> getInfoGeneral(@RequestBody InfoGeneralRequest info) {

    logger.error(info);
    try {
      return new ResponseEntity<String>(
        new Gson().toJson(this.infoGeneralfacade.getInfo(info)),
        HttpStatus.ACCEPTED
      );
    } catch (Exception e) {
      logger.error(e);
      return new ResponseEntity<String>(
        new Gson().toJson(e),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }
}
