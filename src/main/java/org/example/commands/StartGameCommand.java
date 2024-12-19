package org.example.commands;

import org.example.controllers.GameController;
import org.example.models.Game;
import org.example.models.User;

public class StartGameCommand implements ICommand{
    private GameController gameController;
    private User user;
    /*@Override
    public boolean matches(String command) {
        return command.equals("start");
    }*/
    public StartGameCommand(GameController gameController, User user){
        this.gameController = gameController;
        this.user = user;
    }
    @Override
    public void execute() {
        if (user != null) { // Check if the user is registered
            gameController.startGame();
        } else {
            System.out.println("User  not registered. Please create a user first.");
        }
    }
}
