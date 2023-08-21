package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.UserResponseDto;
import com.pragma.powerup.application.handler.IObjectHandler;
import com.pragma.powerup.application.mapper.IObjectRequestMapper;
import com.pragma.powerup.application.mapper.IObjectResponseMapper;
import com.pragma.powerup.domain.api.IRoleServicePort;
import com.pragma.powerup.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ObjectHandler implements IObjectHandler {

    private final IRoleServicePort objectServicePort;
    private final IObjectRequestMapper objectRequestMapper;
    private final IObjectResponseMapper objectResponseMapper;

    @Override
    public void saveObject(UserRequestDto userRequestDto) {
        UserModel userModel = objectRequestMapper.toObject(userRequestDto);
        objectServicePort.saveObject(userModel);
    }

    @Override
    public List<UserResponseDto> getAllObjects() {
        return objectResponseMapper.toResponseList(objectServicePort.getAllObjects());
    }
}