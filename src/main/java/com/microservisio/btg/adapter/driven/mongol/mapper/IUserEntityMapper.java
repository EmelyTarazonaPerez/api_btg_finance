package com.microservisio.trazabilidad.adapter.driven.mongol.mapper;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.UserEntity;
import com.microservisio.trazabilidad.domain.model.UserModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserEntityMapper {
    @Mappings(value = {
            @Mapping(source = "id", target="id"),
            @Mapping(source = "name", target="name"),
            @Mapping(source = "availableCash", target = "available_cash"),
    })
    UserEntity toUserEntity (UserModel userModel);

    @InheritInverseConfiguration
    UserModel toUserModel(UserEntity userEntity);
}
