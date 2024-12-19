package org.example.services;

import org.example.models.User;
import org.example.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser (String username , String password, int userId) {
        if(!userExists(username)){
            User user = new User(username , password , userId);
            userRepository.addUser(user);
            System.out.println("User  registered successfully.");
        }
        else{
            // here it will show no of win loss total match played and if want to play more
            System.out.println("User already exists");
        }
    }

    public boolean userExists(String username){
        //Logic to check if user exist in the user repository
        for (User  user : userRepository.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true; // User exists
            }
        }
        return false; // User does not exist
    }

    public User getUser (String username) {
        // Logic to retrieve the user from the repository
        for (User  user : userRepository.getUsers()) {
            if (user.getUsername().equals(username)) {
                return user; // Return the user if found
            }
        }
        return null; // Return null if user not found
    }
}

