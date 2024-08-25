package com.microservisio.trazabilidad.adapter.driving.http.mapper;

import com.microservisio.trazabilidad.adapter.driving.http.dto.InfoSubscribeFundRequest;
import com.microservisio.trazabilidad.domain.model.ResponseObject.InfoSubscribeFundModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IInfoSubscribeFundMapper {
    InfoSubscribeFundModel toTransactionModel(InfoSubscribeFundRequest object);

}
