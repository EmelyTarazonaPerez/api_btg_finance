package com.microservisio.trazabilidad.domain.model;

import org.bson.types.ObjectId;

public class UserModel {
    public ObjectId id;
    public String name;
    public float availableCash;

    public UserModel(ObjectId id, String name, float availableCash) {
        this.id = id;
        this.name = name;
        this.availableCash = availableCash;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvailableCash() {
        return availableCash;
    }

    public void setAvailableCash(float availableCash) {
        this.availableCash = availableCash;
    }
}
