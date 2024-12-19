package org.example.repositories;

import org.example.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository(){
        this.users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }
}