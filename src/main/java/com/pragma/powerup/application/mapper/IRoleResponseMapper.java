package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.RoleResponseDto;
import com.pragma.powerup.domain.model.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleResponseMapper {

    RoleResponseDto toResponse(RoleModel role);

    List<RoleResponseDto> toResposeList(List<RoleModel> roleList);
}