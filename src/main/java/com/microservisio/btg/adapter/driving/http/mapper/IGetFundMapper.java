package com.microservisio.trazabilidad.adapter.driving.http.mapper;

import com.microservisio.trazabilidad.adapter.driving.http.dto.FundDto;
import com.microservisio.trazabilidad.domain.model.FundModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IGetFundMapper {
    @Mappings(value = {
            @Mapping(source = "id", target="id"),
            @Mapping(source = "name", target="name"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "min_amount", target = "min_amount"),
            @Mapping(source = "category", target = "category"),
    })
    FundDto toFundDto (FundModel fundModel);
    List<FundDto> toFundDto (List<FundModel> fundModel);

    @InheritInverseConfiguration
    FundModel toFundModel (FundDto fundDto);
}
