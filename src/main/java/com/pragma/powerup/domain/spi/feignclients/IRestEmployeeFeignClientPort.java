package com.pragma.powerup.domain.spi.feignclients;

import com.pragma.powerup.domain.model.RestEmployeeModel;
import com.pragma.powerup.domain.model.RestaurantModel;

public interface IRestEmployeeFeignClientPort {
    void saveRestEmployee(RestEmployeeModel restEmployeeModel);
}
