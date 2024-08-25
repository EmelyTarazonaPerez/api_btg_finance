package com.microservisio.trazabilidad.adapter.driven.mongol.repository;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.TransactionEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends MongoRepository<TransactionEntity, String> {
}
