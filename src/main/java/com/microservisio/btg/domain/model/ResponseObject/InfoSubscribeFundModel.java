package com.microservisio.trazabilidad.domain.model.ResponseObject;

import org.bson.types.ObjectId;

public class InfoSubscribeFundModel {
    public String fundId;
    public float amount;

    public InfoSubscribeFundModel(String fundId, float amount) {
        this.fundId = fundId;
        this.amount = amount;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
