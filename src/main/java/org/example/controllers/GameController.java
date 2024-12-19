package org.example.controllers;

import org.example.models.Game;

import java.util.Scanner;

public class GameController {
    private Game game;
    public GameController(){
        this.game = new Game();
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snake and Ladder Game! ");
        while(true){
            System.out.println("Enter number of players (1-4): ");
            int numPlayers = scanner.nextInt();
            if(numPlayers >= 1 && numPlayers <= 4){
                game.initializePlayers(numPlayers);
                game.play();
                break;
            }else{
                System.out.println("Invalid number of players. Please enter a number between 1 and 4.");
            }
        }
    }
}
