package com.pragma.powerup.domain.spi.feignclients;

import com.pragma.powerup.domain.model.RestaurantModel;

public interface IRestaurantFeignClientPort {
    RestaurantModel getRestaurantByOwnerId(Long ownerId);
}
