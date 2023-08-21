package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.RoleModel;
import com.pragma.powerup.domain.model.UserModel;

import javax.management.relation.Role;
import java.util.List;

public interface IRoleServicePort {

    void saveRole(RoleModel role);

    RoleModel getRoleById(Long id);

    List<RoleModel> getAllRoles();

    void deleteRoleById(Long id);
}