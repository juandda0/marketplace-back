package com.juannn.Login_register.controllers;

import com.juannn.Login_register.dto.UserRegisterDTO;
import com.juannn.Login_register.models.User;
import com.juannn.Login_register.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/regist")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        Map<String, Object> response = new HashMap<>();
        logger.info("received registration request: {}" + userRegisterDTO);
        try {
            User registeredUser = userService.save(userRegisterDTO);
            response.put("message", "User registered successfully");
            logger.info("user registered successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            logger.info("user registration failed");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
