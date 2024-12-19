package org.example.models;

import java.util.List;

public class Player {
    private User user ;
    private int playerId;
    private Piece piece;
    private int position;

    public Player(User user, Piece piece , int playerId){
        this.user = user;
        this.piece = piece;
        this.playerId = playerId;
        this.position = 0; //Start at the beginning of the board
    }

    public User getUser() {
        return user;
    }

    public int getPosition() {
        return position;
    }
    public Piece getPiece() {
        return piece;
    }
    public int getPlayerId() {
        return playerId;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public void move(int steps) {
        int newposition = position + steps;
        if(newposition >= 99){
            position = 99;
        }
        else{
            position = newposition;
        }
    }
}
