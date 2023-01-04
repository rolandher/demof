package com.fami.demo.service;

import com.fami.demo.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserModel saveUser(UserModel userModel);

    Optional<UserModel> getUser(Long idUser);

    List<UserModel> getAll();

    Boolean deleteUser(Long id);


}
