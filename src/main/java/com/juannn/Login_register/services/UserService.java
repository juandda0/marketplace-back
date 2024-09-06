package com.juannn.Login_register.services;


import com.juannn.Login_register.dto.UserRegisterDTO;
import com.juannn.Login_register.models.User;

public interface UserService {

    public User save(UserRegisterDTO userDTO);
}
