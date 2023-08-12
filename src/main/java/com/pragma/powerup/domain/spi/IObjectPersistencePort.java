package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.UserModel;
import java.util.List;

public interface IObjectPersistencePort {
    UserModel saveObject(UserModel userModel);

    List<UserModel> getAllObjects();
}