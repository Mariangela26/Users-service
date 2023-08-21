package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRoleServicePort;
import com.pragma.powerup.domain.model.RoleModel;
import com.pragma.powerup.domain.spi.persistence.IRolePersistencePort;

import javax.management.relation.Role;
import java.util.List;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }



    @Override
    public void saveRole(RoleModel role) {
        rolePersistencePort.saveRole(role);
    }

    @Override
    public RoleModel getRoleById(Long id) {
        return rolePersistencePort.getRoleById(id);
    }

    @Override
    public List<RoleModel> getAllRoles() {
        return rolePersistencePort.getAllRoles();
    }

    @Override
    public void deleteRoleById(Long id) {
        rolePersistencePort.deleteRoleById(id);
    }
}