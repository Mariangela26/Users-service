package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IRoleServicePort;
import com.pragma.powerup.domain.spi.persistence.IRolePersistencePort;
import com.pragma.powerup.domain.usecase.RoleUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.RoleJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IObjectEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IObjectRepository objectRepository;
    private final IObjectEntityMapper objectEntityMapper;

    @Bean
    public IRolePersistencePort objectPersistencePort() {
        return new RoleJpaAdapter(objectRepository, objectEntityMapper);
    }

    @Bean
    public IRoleServicePort objectServicePort() {
        return new RoleUseCase(objectPersistencePort());
    }
}