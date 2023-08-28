package com.pragma.powerup.infrastructure.out.feignclients;

import com.pragma.powerup.application.dto.request.RestEmployeeRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
@FeignClient(contextId = "restaurantEmployee",name = "plaza-service", url = "localhost:8082/api/v1/restaurantEmployee")
public interface RestEmployeeFeignClient {

    @PostMapping("/")
    void saveRestaurantEmployee(RestEmployeeRequestDto restaurantEmployeeRequestDto);




}
