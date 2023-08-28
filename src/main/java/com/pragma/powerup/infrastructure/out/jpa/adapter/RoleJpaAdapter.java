package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.RoleModel;
import com.pragma.powerup.domain.spi.persistence.IRolePersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.RoleEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRoleEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {

    private  final IRoleRepository roleRepository;
    private  final IRoleEntityMapper roleEntityMapper;

    @Override
    public RoleModel saveRole(RoleModel role) {
        RoleEntity roleEntity = roleRepository.save(roleEntityMapper.toEntity(role));
        return roleEntityMapper.toRoleModel(roleEntity);
    }

    @Override
    public RoleModel getRoleById(Long id) {
        Optional<RoleEntity> optionalRolEntity = roleRepository.findById(id);
        RoleEntity roleEntity = optionalRolEntity.orElse(null);
        return roleEntityMapper.toRoleModel(roleEntity);
    }

    @Override
    public List<RoleModel> getAllRoles() {
        List<RoleEntity> rolEntityList = roleRepository.findAll();
        if(rolEntityList.isEmpty()){
            throw  new NoDataFoundException();
        }
        return roleEntityMapper.toRoleModelList(rolEntityList);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
}
