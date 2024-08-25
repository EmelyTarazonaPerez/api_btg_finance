package com.microservisio.trazabilidad.adapter.driving.http.mapper;

import com.microservisio.trazabilidad.adapter.driving.http.dto.UserDto;
import com.microservisio.trazabilidad.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    UserDto toUserDto(UserModel object);
}
