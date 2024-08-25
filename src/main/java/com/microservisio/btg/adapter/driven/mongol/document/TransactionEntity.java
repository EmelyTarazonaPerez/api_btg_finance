package com.microservisio.trazabilidad.adapter.driven.mongol.document;

import com.microservisio.trazabilidad.utils.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "transaction_history")
public class TransactionEntity {
    @Id
    private String id;
    public String userId;
    public FundEntity fund;
    public float amount;
    public Date date;
    public boolean active;
    private Type type;

}
