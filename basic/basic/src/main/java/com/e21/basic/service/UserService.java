package com.e21.basic.service;

import com.e21.basic.exception.PasswordIncorrectException;
import com.e21.basic.exception.UserNotFoundException;
import com.e21.basic.exception.UsernameAlreadyExistsException;
import com.e21.basic.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> list = new ArrayList<>();

    public String signup(User user) {
        String username = user.getUsername();
        for(User i : list) {
            if(username.equals(i.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
        list.add(user);
        return "Signup successful";
    }

    public String login(User user) {
        String username = user.getUsername();
        boolean isPresent = false;
        User stored = null;
        for(User i : list) {
            if(i.getUsername().equals(username)) {
                isPresent = true;
                stored = i;
                break;
            }
        }
        if(!isPresent)
            throw new UserNotFoundException(username);
        if(!user.getPassword().equals(stored.getPassword()))
            throw new PasswordIncorrectException();
        return "Login successful";
    }
}
