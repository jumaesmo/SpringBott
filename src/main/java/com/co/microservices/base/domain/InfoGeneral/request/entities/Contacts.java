package com.co.microservices.base.domain.InfoGeneral.request.entities;

public class Contacts {
    private boolean callbackReferent;
    private Contact contact;

    public boolean isCallbackReferent() {
        return callbackReferent;
    }

    public void setCallbackReferent(boolean callbackReferent) {
        this.callbackReferent = callbackReferent;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
