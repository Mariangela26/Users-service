package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.UserModel;

import java.util.List;

public interface IUserServicePort {
    void saveUser(UserModel userModel);

    void saveRestaurantEmployee(UserModel userModel);

    UserModel getUserById(Long id);

    UserModel getUserByEmail(String email);

    Boolean existsUserById(Long id);

    List<UserModel> getAllUsers();

    void deleteUserById(Long id);
}
