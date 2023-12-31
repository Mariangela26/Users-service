package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.application.mapper.IRestEmployeeRequestMapper;
import com.pragma.powerup.application.mapper.IRestaurantResponseMapper;
import com.pragma.powerup.domain.api.IRoleServicePort;
import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.spi.IToken;
import com.pragma.powerup.domain.spi.IUserPassEncodePort;
import com.pragma.powerup.domain.spi.feignclients.IRestEmployeeFeignClientPort;
import com.pragma.powerup.domain.spi.feignclients.IRestaurantFeignClientPort;
import com.pragma.powerup.domain.spi.persistence.IRolePersistencePort;
import com.pragma.powerup.domain.spi.persistence.IUserPersistencePort;
import com.pragma.powerup.domain.usecase.RoleUseCase;
import com.pragma.powerup.domain.usecase.UserUseCase;
import com.pragma.powerup.infrastructure.out.BCrypPasswordEncoderAdapter;
import com.pragma.powerup.infrastructure.out.TokenAdapter;
import com.pragma.powerup.infrastructure.out.feignclients.RestEmployeeFeignClient;
import com.pragma.powerup.infrastructure.out.feignclients.RestaurantFeignClient;
import com.pragma.powerup.infrastructure.out.feignclients.adapter.RestEmployeeFeignAdapter;
import com.pragma.powerup.infrastructure.out.feignclients.adapter.RestaurantFeignAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.RoleJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRoleEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRoleRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private  final IUserRepository userRepository;
    private  final IUserEntityMapper userEntityMapper;

    private final IRoleRepository rolRepository;

    private final IRoleEntityMapper rolEntityMapper;

    private final RestEmployeeFeignClient restaurantEmployeeFeignClient;

    private final IRestEmployeeRequestMapper restaurantEmployeeRequestMapper;

    private final RestaurantFeignClient restaurantFeignClient;
    private final IRestaurantResponseMapper restaurantResponseMapper;

    @Bean
    public IUserPassEncodePort userPasswordEncoderPort(){
        return new BCrypPasswordEncoderAdapter();
    }

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort(), userPasswordEncoderPort(), restaurantEmployeeFeignClientPort(), token(), restaurantFeignClientPort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort(){
        return new RoleJpaAdapter(rolRepository, rolEntityMapper);
    }

    @Bean
    public IRoleServicePort roleServicePort(){
        return  new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public IRestEmployeeFeignClientPort restaurantEmployeeFeignClientPort(){
        return new RestEmployeeFeignAdapter(restaurantEmployeeFeignClient, restaurantEmployeeRequestMapper);
    }

    @Bean
    public IRestaurantFeignClientPort restaurantFeignClientPort(){
        return new RestaurantFeignAdapter(restaurantFeignClient, restaurantResponseMapper);
    }
    @Bean
    public IToken token(){
        return new TokenAdapter();
    }


}