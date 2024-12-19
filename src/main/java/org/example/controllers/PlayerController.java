package org.example.controllers;

import org.example.models.Player;

public class PlayerController {
    public void movePlayer(Player player , int steps){
        player.move(steps);
    }
}
