package org.example;

import org.example.commands.CommandRegistry;
import org.example.commands.CreateUserCommand;
import org.example.commands.StartGameCommand;
import org.example.controllers.GameController;
import org.example.controllers.UserController;
import org.example.exceptions.InvalidCommandException;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);
        GameController gameController = new GameController();
        //CommandRegistry commandRegistry = new CommandRegistry();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Get User Details");
            System.out.println("3. Start Game");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                int userId = 0;
                CreateUserCommand createUserCommand = new CreateUserCommand(userController, username, password , userId);
                createUserCommand.execute();
            }else if (choice == 2) {
                System.out.print("Enter username to get details: ");
                String username = scanner.nextLine();
                User user = userController.getUser (username);
                if (user != null) {
                    System.out.println("User  found: " + user.getUsername() + " " + user.getPassword() + " " + user.getUserId());
                } else {
                    System.out.println("User  not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter username to start the game: ");
                String username = scanner.nextLine();
                User user = userController.getUser (username);
                StartGameCommand startGameCommand = new StartGameCommand(gameController, user); // Pass user to StartGameCommand
                startGameCommand.execute();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
// Command Design Pattern + Registry
// Builder -> Director

// StartGame u1, u2, u3 100 AUTOMATIC
// StartGame u1, u2 500 MANUAL
// 3
// 6  1
// 45  39
// 32  20
// 1
// 8 91

// Assignment
// 1. Make a game run
// Have a factory
// Pass the game object created via factory to gamecontroller