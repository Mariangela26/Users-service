package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.UserModel;

import java.util.List;

public interface IObjectServicePort {

    void saveObject(UserModel userModel);

    List<UserModel> getAllObjects();
}