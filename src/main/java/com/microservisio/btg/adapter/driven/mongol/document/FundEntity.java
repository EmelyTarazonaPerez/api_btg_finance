package com.microservisio.trazabilidad.adapter.driven.mongol.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "funds")
public class FundEntity {
    @Id
    private ObjectId id;
    public String name;
    public String code;
    public float min_amount;
    public String category;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }
}
