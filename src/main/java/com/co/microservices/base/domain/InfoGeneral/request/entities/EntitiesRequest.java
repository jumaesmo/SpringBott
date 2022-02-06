package com.co.microservices.base.domain.InfoGeneral.request.entities;

import com.co.microservices.base.domain.InfoGeneral.request.general.Contacts;
import com.co.microservices.base.domain.InfoGeneral.request.general.Field;

import java.util.List;

public class EntitiesRequest {
    private List<Contacts> contacts;
    private int entityTypeId;
    private List<Field> fields;
    private List<Integer> linkedEntitiesIds;

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    public int getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Integer> getLinkedEntitiesIds() {
        return linkedEntitiesIds;
    }

    public void setLinkedEntitiesIds(List<Integer> linkedEntitiesIds) {
        this.linkedEntitiesIds = linkedEntitiesIds;
    }
}
