package com.co.microservices.base.domain.InfoGeneral.request.cases;

import java.util.Date;
import java.util.List;

public class CasesRequest {

  private List<Integer> contactIds;
  private Date dueDate;
  private EmailContentModel emailContent;
  private int entityId;
  private int workflowId;

  public List<Integer> getContactIds() {
    return contactIds;
  }

  public void setContactIds(List<Integer> contactIds) {
    this.contactIds = contactIds;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public EmailContentModel getEmailContent() {
    return emailContent;
  }

  public void setEmailContent(EmailContentModel emailContent) {
    this.emailContent = emailContent;
  }

  public int getEntityId() {
    return entityId;
  }

  public void setEntityId(int entityId) {
    this.entityId = entityId;
  }

  public int getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(int workflowId) {
    this.workflowId = workflowId;
  }
}
