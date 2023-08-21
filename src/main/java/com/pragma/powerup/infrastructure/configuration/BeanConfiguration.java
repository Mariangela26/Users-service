package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IRoleServicePort;
import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.spi.feignclients.IRestEmployeeFeignClientPort;
import com.pragma.powerup.domain.spi.persistence.IRolePersistencePort;
import com.pragma.powerup.domain.spi.persistence.IUserPersistencePort;
import com.pragma.powerup.domain.usecase.RoleUseCase;
import com.pragma.powerup.domain.usecase.UserUseCase;
import com.pragma.powerup.infrastructure.out.feignclients.RestEmployeeFeignClient;
import com.pragma.powerup.infrastructure.out.feignclients.RestaurantFeignClient;
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
    public IUserPasswordEncoderPort  userPasswordEncoderPort(){
        return new BCrypPasswordEncoderAdapter();
    }

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort(), userPasswordEncoderPort(), restaurantEmployeeFeignClientPort(), token(), restaurantFeingClientPort());
    }

    @Bean
    public IRolePersistencePort rolPersistencePort(){
        return new RolJpaAdapter(rolRepository, rolEntityMapper);
    }

    @Bean
    public IRoleServicePort rolServicePort(){
        return  new RolUseCase(rolPersistencePort());
    }

    @Bean
    public IRestEmployeeFeignClientPort restaurantEmployeeFeignClientPort(){
        return new RestEmployeeFeignAdapter(restaurantEmployeeFeignClient, restaurantEmployeeRequestMapper);
    }

    @Bean
    public IRestaurantFeingClientPort restaurantFeingClientPort(){
        return new RestaurantFeignAdapter(restaurantFeignClient, restaurantResponseMapper);
    }
    @Bean
    public IToken token(){
        return new TokenAdapter();
    }


}