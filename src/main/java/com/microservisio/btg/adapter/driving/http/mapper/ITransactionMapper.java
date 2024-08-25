package com.microservisio.trazabilidad.adapter.driving.http.mapper;

import com.microservisio.trazabilidad.adapter.driving.http.dto.FundDto;
import com.microservisio.trazabilidad.adapter.driving.http.dto.TransactionDto;
import com.microservisio.trazabilidad.domain.model.FundModel;
import com.microservisio.trazabilidad.domain.model.TransactionModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ITransactionMapper {
    TransactionModel toTransactionModel(TransactionDto object);

    @InheritInverseConfiguration
    TransactionDto toTransactionsDto(TransactionModel fundDto);
    List<TransactionDto> toListTransactionsDto(List<TransactionModel> transactionModels);
}
