package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    @Mapping(target = "role.id", source = "rol.id")
    UserEntity toEntity(UserModel user);
    @Mapping(target = "rol.id", source = "rol.id")
    UserModel toUserModel(UserEntity userEntity);

    List<UserModel> toUsuarioModelList(List<UserEntity> userEntityList);
}