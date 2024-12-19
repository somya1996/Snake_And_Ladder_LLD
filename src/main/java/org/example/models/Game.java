package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private Dice dice;
    private Scanner scanner;
    private Player currentPlayer;

    public Game(){
        this.board = new Board();
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.dice = new Dice();
        this.scanner = new Scanner(System.in);
    }
    public void initializePlayers(int numPlayers){
        for(int i = 0; i < numPlayers; i++){
            System.out.println("Enter username for Player"+(i+1));
            String username = scanner.nextLine();
            System.out.println("Enter password for Player"+(i+1));
            String password = scanner.nextLine();
            User user = new User(username, password , players.size());
            players.add(new Player(user , new Piece(Colour.values()[i % Colour.values().length]) , i));
        }
    }

    public void play(){
        while(true){
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println(currentPlayer.getUser().getUsername() + "'s turn. Press Enter to roll the dice. ");
            scanner.nextLine();

            int steps = dice.roll();
            System.out.println(currentPlayer.getUser().getUsername() + " rolled " + steps + " Cell is at " + currentPlayer.getPosition());

            currentPlayer.move(steps);
            Cell cell = board.getCell(currentPlayer.getPosition());

            // Check for win condition
            if (currentPlayer.getPosition() == 99) {
                System.out.println(currentPlayer.getUser ().getUsername() + " wins!");
                break; // Exit the loop or handle the win condition
            }

            // Handle snakes and ladders
            if (cell instanceof Snake) {
                System.out.println(currentPlayer.getUser() + " encountered a snake! Moving down.");
                currentPlayer.setPosition(((Snake) cell).getEndPosition());
            } else if (cell instanceof Ladder) {
                System.out.println(currentPlayer.getUser() + " found a ladder! Climbing up.");
                currentPlayer.setPosition(((Ladder) cell).getEndPosition());
            }

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();

        }
    }
}


// 2 dices
// 1 - 6 -> p(1) -> 1/6
// 1 - 12 -> p(1) -> 1/12
// 2 dices of 1- 6: p(1) -> 0
// implement a uniform random generator?
// math
// 5 -> 1- 12: p(5) 1/12
// 2 dices of 1-6: (1 + 4), (2 + 3), (3 + 2), (4 + 1) ~1/9