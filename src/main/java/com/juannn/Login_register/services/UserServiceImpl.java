package com.juannn.Login_register.services;

import com.juannn.Login_register.dto.UserRegisterDTO;
import com.juannn.Login_register.models.Role;
import com.juannn.Login_register.models.User;
import com.juannn.Login_register.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegisterDTO userDTO) {

        User user = new User(Arrays.asList(new Role("Default")), userDTO.getPassword(),
                userDTO.getEmail(), userDTO.getLastName(), userDTO.getName());

        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return userRepository.save(user);
    }

}
