package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.RoleRequestDto;
import com.pragma.powerup.application.dto.response.RoleResponseDto;
import com.pragma.powerup.application.handler.IRoleHandler;
import com.pragma.powerup.application.mapper.IRoleRequestMapper;
import com.pragma.powerup.application.mapper.IRoleResponseMapper;
import com.pragma.powerup.domain.api.IRoleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandler implements IRoleHandler {

    private final IRoleServicePort roleServicePort;

    private final IRoleRequestMapper roleRequestMapper;

    private final IRoleResponseMapper roleResponseMapper;

    @Override
    public void saveRole(RoleRequestDto roleRequestDto) {

    }

    @Override
    public RoleResponseDto getById(Long id) {
        return null;
    }

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
