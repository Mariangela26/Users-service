package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.persistence.IRolePersistencePort;
import com.pragma.powerup.domain.spi.persistence.IUserPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public UserModel saveUser(UserModel user) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toUserModel(userEntity);
    }

    @Override
    public UserModel getUserById(Long id) {
        Optional<UserEntity> userEntityOptional= userRepository.findById(id);
        UserEntity userEntity =  userEntityOptional.orElse(null) ;
        return userEntityMapper.toUserModel(userEntity) ;
    }

    @Override
    public UserModel getUserByEmail(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);
        UserEntity userEntity = userEntityOptional.orElse(null);
        return userEntityMapper.toUserModel(userEntity);
    }

    @Override
    public Boolean existsUserById(Long id) {
        return  userRepository.existsById(id);

    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserEntity> entityList = userRepository.findAll();
        if(entityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUsuarioModelList(entityList);

    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}