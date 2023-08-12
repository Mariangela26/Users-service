package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.ObjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IObjectEntityMapper {

    ObjectEntity toEntity(UserModel user);
    UserModel toObjectModel(ObjectEntity objectEntity);
    List<UserModel> toObjectModelList(List<ObjectEntity> userEntityList);
}