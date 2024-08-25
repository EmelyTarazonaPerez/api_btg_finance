package com.microservisio.trazabilidad.adapter.driven.mongol.repository;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.FundEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFundRepository extends MongoRepository <FundEntity, String> {
}
