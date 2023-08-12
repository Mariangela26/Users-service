package com.pragma.powerup.domain.spi.persistence;

import com.pragma.powerup.domain.model.UserModel;

import javax.management.relation.Role;
import java.util.List;

public interface IRolePersistencePort {
    Role saveRole(Role role);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    void deleteRoleById(Long id);
}