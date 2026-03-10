package com.e21.basic.service;

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
                return "Username already exists";
        }
        list.add(user);
        return "Signup successful";
    }

    public String login(User user) {
        String username = user.getUsername();
        for(User i : list) {
            if(username.equals(i.getUsername())) {
                if(user.getPassword().equals(i.getPassword()))
                    return "Login successful";
                else
                    return "Wrong password";
            }
        }
        return "Username: " + username + "doesn't exists";
    }
}
