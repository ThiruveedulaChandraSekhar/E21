package com.e21.todo.service;

import com.e21.todo.exception.PasswordIncorrectException;
import com.e21.todo.exception.UserNotFoundException;
import com.e21.todo.exception.UsernameAlreadyExistsException;
import com.e21.todo.model.User;
import com.e21.todo.payload.UserDTO;
import com.e21.todo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String signup(UserDTO user) {
        Optional<User> stored = userRepository.findByUsername(user.getUsername());
        if(stored.isPresent())
            throw new UsernameAlreadyExistsException(user.getUsername());
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
        return "Signup successful";
    }

    public String login(UserDTO user) {
        User stored = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new UserNotFoundException(user.getUsername()));
        if(!user.getPassword().equals(stored.getPassword()))
            throw new PasswordIncorrectException();
        return "Login successful";
    }
}
