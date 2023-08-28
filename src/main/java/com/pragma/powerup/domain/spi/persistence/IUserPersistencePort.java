package com.pragma.powerup.domain.spi.persistence;

import com.pragma.powerup.domain.model.UserModel;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface IUserPersistencePort {
    UserModel saveUser(UserModel user);

    UserModel getUserById(Long id);

    UserModel getUserByEmail(String email);

    Boolean existsUserById(Long id);

    List<UserModel> getAllUsers();

    void deleteUserById(Long id);
}
