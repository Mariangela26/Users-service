package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.RoleRequestDto;
import com.pragma.powerup.application.dto.response.RoleResponseDto;

import java.util.List;

public interface IRoleHandler {
    void saveRole(RoleRequestDto roleRequestDto);

    RoleResponseDto getById(Long id);

    List<RoleResponseDto> getAllRoles();

    void deleteById(Long id);
}
