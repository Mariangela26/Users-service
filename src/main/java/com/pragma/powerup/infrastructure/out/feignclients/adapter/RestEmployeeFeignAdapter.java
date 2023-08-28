package com.pragma.powerup.infrastructure.out.feignclients.adapter;

import com.pragma.powerup.application.dto.request.RestEmployeeRequestDto;
import com.pragma.powerup.application.mapper.IRestEmployeeRequestMapper;
import com.pragma.powerup.domain.model.RestEmployeeModel;
import com.pragma.powerup.domain.spi.feignclients.IRestEmployeeFeignClientPort;
import com.pragma.powerup.infrastructure.out.feignclients.RestEmployeeFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestEmployeeFeignAdapter implements IRestEmployeeFeignClientPort {
    private  final RestEmployeeFeignClient restEmployeeFeignClient;

    private final IRestEmployeeRequestMapper restEmployeeRequestMapper;
    @Override
    public void saveRestEmployee(RestEmployeeModel restaurantEmployeeModel) {
        RestEmployeeRequestDto restaurantEmployeeRequestDto = restEmployeeRequestMapper.toRequest(restaurantEmployeeModel);
        restEmployeeFeignClient.saveRestaurantEmployee(restaurantEmployeeRequestDto);
    }
}
