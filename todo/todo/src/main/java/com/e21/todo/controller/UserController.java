package com.e21.todo.controller;

import com.e21.todo.model.User;
import com.e21.todo.payload.UserDTO;
import com.e21.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDTO user) {
        return new ResponseEntity<>(service.signup(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO user) {
        return new ResponseEntity<>(service.login(user), HttpStatus.OK);
    }
}
