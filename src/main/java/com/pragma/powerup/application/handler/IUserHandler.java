package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.UserResponseDto;
import org.apache.catalina.User;

import java.util.List;

public interface IUserHandler {

    void saveUser(UserRequestDto userRequestDto);

    void saveRestEmployee(UserRequestDto userRequestDto);

    UserResponseDto getUserById(Long id);
    UserResponseDto getUserByEmail(String email);

    Boolean existsUserById(Long id);

    List<UserResponseDto> getAllUsers();

    void deleteUserById(Long id);
}