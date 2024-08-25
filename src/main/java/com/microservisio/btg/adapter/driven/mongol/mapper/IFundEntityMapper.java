package com.microservisio.trazabilidad.adapter.driven.mongol.mapper;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.FundEntity;
import com.microservisio.trazabilidad.adapter.driving.http.dto.FundDto;
import com.microservisio.trazabilidad.domain.model.FundModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IFundEntityMapper {
    @Mappings(value = {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "min_amount", target = "min_amount"),
            @Mapping(source = "category", target = "category"),
    })
    List<FundModel> toListFundModel (List<FundEntity> fundEntities);
    FundModel toFundModel (FundEntity fundEntity);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    FundEntity toFundEntity(FundModel fundModel);
}
