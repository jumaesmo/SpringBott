package com.co.microservices.base.domain.InfoGeneral.request.cases;

public class EmailContentModel {

  private String emailHtml;
  private int emailId;
  private String emailSubject;

  public String getEmailHtml() {
    return emailHtml;
  }

  public void setEmailHtml(String emailHtml) {
    this.emailHtml = emailHtml;
  }

  public int getEmailId() {
    return emailId;
  }

  public void setEmailId(int emailId) {
    this.emailId = emailId;
  }

  public String getEmailSubject() {
    return emailSubject;
  }

  public void setEmailSubject(String emailSubject) {
    this.emailSubject = emailSubject;
  }
}
