package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.model.RestEmployeeModel;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.model.RoleModel;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IUserPassEncodePort;
import com.pragma.powerup.domain.spi.feignclients.IRestEmployeeFeignClientPort;
import com.pragma.powerup.domain.spi.feignclients.IRestaurantFeignClientPort;
import com.pragma.powerup.domain.spi.persistence.IUserPersistencePort;
import com.pragma.powerup.domain.spi.IToken;

import javax.management.relation.Role;
import java.util.List;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private  final IUserPassEncodePort userPassEncoderPort;
    private  final IRestEmployeeFeignClientPort restaurantEmployeeFeignClientPort;
    private final IToken token;
    private final IRestaurantFeignClientPort restaurantFeignClientPort;

    public UserUseCase(IUserPersistencePort userPersistencePort, IUserPassEncodePort userPassEncoderPort, IRestEmployeeFeignClientPort restEmployeeFeignClientPort, IToken token, IRestaurantFeignClientPort restaurantFeignClientPort) {
        this.userPersistencePort = userPersistencePort;
        this.userPassEncoderPort = userPassEncoderPort;
        this.restaurantEmployeeFeignClientPort = restEmployeeFeignClientPort;
        this.token = token;
        this.restaurantFeignClientPort = restaurantFeignClientPort;
    }
    @Override
    public void saveUser(UserModel userModel) {
        validateRolesAuthAndNot(userModel);
        userModel.setPass(userPassEncoderPort.encode(userModel.getPass()));
        userPersistencePort.saveUser(userModel);

    }
    private void validateRolesAuthAndNot(UserModel userModel){
        String bearerToken = token.getBearerToken();
        RoleModel roleModel = new RoleModel();
        String rolS = "";
        if(!(bearerToken==null)) {

            rolS = token.getUserAutenticateRol(bearerToken);
            System.out.println(rolS);
        }

        if(rolS.equals("OWNER")){
            //Puede crear empleados
            roleModel.setId(3L);
        }else if(rolS.equals("ADMIN")){
            //Puede crear propietarios
            roleModel.setId(2L);
        }else{
            if(userModel.getRoleModel().getId()==null){
                roleModel.setId(4L);
            }else
            if(userModel.getRoleModel().getId()==1){
                //Si entra aqui, se registra un ADMIN
                System.out.println("Se esta registrando un ADMIN");
            }

        }
        //Si el Rol no es nulo, puede setearse al usuario, (Se valida ya que al ADMIN solo se le pasa el rol en el body del JSON)
        if(!(roleModel.getId()==null)){
            userModel.setRoleModel(roleModel);
        }
    }

    @Override
    public void saveRestaurantEmployee(UserModel userModel) {

        RestEmployeeModel restEmployeeModel = new RestEmployeeModel();
        String bearerToken = token.getBearerToken();
        Long idOwnerAuth = token.getUserAutenticateId(bearerToken);

        RestaurantModel restaurantModel = restaurantFeignClientPort.getRestaurantByOwnerId(idOwnerAuth);
        String restaurantId = String.valueOf(restaurantModel.getId());
        System.out.println(restaurantId);
        String employee_id = String.valueOf(userPersistencePort.getUserByEmail(userModel.getEmail()).getId());
        System.out.println(employee_id);

        restEmployeeModel.setRestaurantId(restaurantId);
        restEmployeeModel.setUserId(employee_id);
        restaurantEmployeeFeignClientPort.saveRestEmployee(restEmployeeModel);

    }

    @Override
    public UserModel getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }

    @Override
    public UserModel getUserByEmail(String email) {
        return userPersistencePort.getUserByEmail(email);
    }

    @Override
    public Boolean existsUserById(Long id) {
        return userPersistencePort.existsUserById(id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }

    @Override
    public void deleteUserById(Long id) {
        userPersistencePort.deleteUserById(id);
    }
}
