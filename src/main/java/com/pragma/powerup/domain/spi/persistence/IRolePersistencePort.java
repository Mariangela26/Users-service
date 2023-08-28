package com.pragma.powerup.domain.spi.persistence;

import com.pragma.powerup.domain.model.RoleModel;
import com.pragma.powerup.domain.model.UserModel;

import javax.management.relation.Role;
import java.util.List;

public interface IRolePersistencePort {
    RoleModel saveRole(RoleModel role);

    RoleModel getRoleById(Long id);

    List<RoleModel> getAllRoles();

    void deleteRoleById(Long id);
}