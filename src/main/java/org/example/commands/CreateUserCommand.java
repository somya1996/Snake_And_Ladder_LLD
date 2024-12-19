package org.example.commands;

import org.example.controllers.UserController;
import org.example.services.UserService;

import java.util.List;

public class CreateUserCommand implements ICommand {
    private UserController userController;
    private String username;
    private String password;
    private  int userId;

    public CreateUserCommand(UserController userController, String username, String password , int userId) {
        this.userController = userController;
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    @Override
    public void execute() {
        userController.registerUser(username , password , userId);

    }
}