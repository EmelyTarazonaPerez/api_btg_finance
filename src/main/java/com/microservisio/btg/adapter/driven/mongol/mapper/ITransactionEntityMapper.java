package com.microservisio.trazabilidad.adapter.driven.mongol.mapper;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.TransactionEntity;
import com.microservisio.trazabilidad.domain.model.TransactionModel;
import org.bson.types.ObjectId;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ITransactionEntityMapper {
    @Mappings(value = {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "fund", target = "fund"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "type", target = "type")
    })
    List<TransactionModel> toListTransactionModel(List<TransactionEntity> transactionEntities);
    TransactionModel toTransactionModel(TransactionEntity transactionEntity);
}
