package com.microservisio.trazabilidad.domain.model.ResponseObject;

import com.microservisio.trazabilidad.domain.model.FundModel;

public class ResponseModel {
    private Object model;
    private String message;
    private boolean success;

    // Getters y Setters

    public ResponseModel(Object model, String message, boolean success) {
        this.model = model;
        this.message = message;
        this.success = success;
    }

    public Object getFundModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
