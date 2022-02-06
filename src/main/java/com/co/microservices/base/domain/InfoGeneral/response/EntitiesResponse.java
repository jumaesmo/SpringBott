package com.co.microservices.base.domain.InfoGeneral.response;

import java.util.List;

public class EntitiesResponse {
    private List<String> errors;

    public EntitiesResponse(List<String> errors) {
        this.errors = errors;
    }
    public EntitiesResponse() {

    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
