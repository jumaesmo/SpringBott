package com.co.microservices.base.domain.InfoGeneral.response.cases;

import java.util.List;

public class CasesResponse {

  private int caseId;
  private String link;
  private List<PortalLinkModel> portalLinks;
  private String status;

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public List<PortalLinkModel> getPortalLinks() {
    return portalLinks;
  }

  public void setPortalLinks(List<PortalLinkModel> portalLinks) {
    this.portalLinks = portalLinks;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
