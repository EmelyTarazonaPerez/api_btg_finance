package com.microservisio.trazabilidad.adapter.driven.mongol.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "users")
public class UserEntity {
    public ObjectId id;
    public String name;
    public float available_cash;
}
