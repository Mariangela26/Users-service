package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.UserResponseDto;
import com.pragma.powerup.application.handler.IUserHandler;
import com.pragma.powerup.application.mapper.IUserRequestMapper;
import com.pragma.powerup.application.mapper.IUserResponseMapper;
import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(userModel);
    }

    @Override
    public void saveRestEmployee(UserRequestDto userRequestDto) {
        UserModel user = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveRestaurantEmployee(user);

    }

    @Override
    public UserResponseDto getUserById(Long id) {
        UserResponseDto userResponseDto = userResponseMapper.toResponse(userServicePort.getUserById(id));
        return userResponseDto;
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        UserResponseDto userResponseDto = userResponseMapper.toResponse(userServicePort.getUserByEmail(email));
        return userResponseDto;
    }

    @Override
    public Boolean existsUserById(Long id) {
        return userServicePort.existsUserById(id);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userResponseMapper.toResponseList(userServicePort.getAllUsers());
    }

    @Override
    public void deleteUserById(Long id) {
        userServicePort.deleteUserById(id);
    }
}