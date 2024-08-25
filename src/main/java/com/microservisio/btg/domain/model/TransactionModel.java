package com.microservisio.trazabilidad.domain.model;

import com.microservisio.trazabilidad.utils.Type;

import java.util.Date;

public class TransactionModel {
    public String id;
    public String userId;
    public FundModel fund;
    public float amount;
    public Date date;
    public boolean active;
    public Type type;

    public TransactionModel(String id, String userId, FundModel fund, float amount, Date date, boolean active, Type type) {
        this.id = id;
        this.userId = userId;
        this.fund = fund;
        this.amount = amount;
        this.date = date;
        this.active = active;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public FundModel getFund() {
        return fund;
    }

    public void setFund(FundModel fund) {
        this.fund = fund;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
