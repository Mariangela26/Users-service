package com.pragma.powerup.infrastructure.out.feignclients.adapter;

import com.pragma.powerup.application.dto.response.RestaurantResponseDto;
import com.pragma.powerup.application.mapper.IRestaurantResponseMapper;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.spi.feignclients.IRestaurantFeignClientPort;
import com.pragma.powerup.infrastructure.out.feignclients.RestaurantFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestaurantFeignAdapter implements IRestaurantFeignClientPort {
    private final RestaurantFeignClient restaurantFeignClient;

    private final IRestaurantResponseMapper restaurantResponseMapper;
    @Override
    public RestaurantModel getRestaurantByOwnerId(Long idOwner) {
        RestaurantResponseDto restaurantResponseDto = restaurantFeignClient.getRestaurantByOwnerId(idOwner);
        return restaurantResponseMapper.toRestaurantModel(restaurantResponseDto);
    }
}
