package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IObjectServicePort;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IObjectPersistencePort;

import java.util.List;

public class ObjectUseCase implements IObjectServicePort {

    private final IObjectPersistencePort objectPersistencePort;

    public ObjectUseCase(IObjectPersistencePort objectPersistencePort) {
        this.objectPersistencePort = objectPersistencePort;
    }

    @Override
    public void saveObject(UserModel userModel) {
        objectPersistencePort.saveObject(userModel);
    }

    @Override
    public List<UserModel> getAllObjects() {
        return objectPersistencePort.getAllObjects();
    }
}