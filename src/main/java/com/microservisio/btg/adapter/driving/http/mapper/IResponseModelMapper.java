package com.microservisio.trazabilidad.adapter.driving.http.mapper;

import com.microservisio.trazabilidad.adapter.driving.http.dto.ResponseObject.ResponseModelDto;
import com.microservisio.trazabilidad.domain.model.ResponseObject.ResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IResponseModelMapper {
    @Mappings(value = {
            @Mapping(source = "fundModel", target="fundModel"),
            @Mapping(source = "message", target="message"),
            @Mapping(source = "success", target = "success"),
    })
    ResponseModelDto toResponseModelDto(ResponseModel responseModel);
}
