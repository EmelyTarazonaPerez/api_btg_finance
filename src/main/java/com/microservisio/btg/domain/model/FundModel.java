package com.microservisio.trazabilidad.domain.model;

import org.bson.types.ObjectId;

public class FundModel {
    private String id;
    private String name;
    private String code;
    private float min_amount;
    private String category;

    public FundModel(String id, String name, String code, float min_amount, String category) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.min_amount = min_amount;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getMin_amount() {
        return min_amount;
    }

    public void setMin_amount(float min_amount) {
        this.min_amount = min_amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

