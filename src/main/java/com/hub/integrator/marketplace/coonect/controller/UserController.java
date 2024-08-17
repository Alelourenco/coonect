package com.hub.integrator.marketplace.coonect.controller;

import com.hub.integrator.marketplace.coonect.entity.User;
import com.hub.integrator.marketplace.coonect.model.UserDTO;
import com.hub.integrator.marketplace.coonect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        // Converter UserDTO para User
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword(), userService.getPasswordEncoder()); // Codificar senha
        userService.saveUser(user); // Salvar no repositório
        return ResponseEntity.ok(user);
    }
}

