package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.RestEmployeeRequestDto;
import com.pragma.powerup.domain.model.RestEmployeeModel;

public interface IRestEmployeeRequestMapper {
    RestEmployeeModel toRestaurantEmployeeModel(RestEmployeeRequestDto restEmployeeRequestDto);

    RestEmployeeRequestDto toRequest(RestEmployeeModel restEmployeeModel);
}
