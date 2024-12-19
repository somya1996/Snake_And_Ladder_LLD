package org.example.controllers;

import org.example.commands.StartGameCommand;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.services.UserService;

public class UserController {
    private UserService userService;
    private StartGameCommand startGameCommand;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void registerUser (String username , String password , int userId) {
        if(userService.userExists(username)){
            System.out.println("User already exists");
            //startGameCommand.execute();
        }
        else {
            userService.registerUser(username, password , userId);
        }
    }

    public User getUser (String username) {
        if(userService.userExists(username)){
            return userService.getUser (username);
        }
        else{
            System.out.println("User does not exist");
            userService.registerUser(username, "password", 0);
            return null;
        }
    }
}
