package com.microservisio.trazabilidad.adapter.driven.mongol.repository;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<UserEntity, String> {
}
