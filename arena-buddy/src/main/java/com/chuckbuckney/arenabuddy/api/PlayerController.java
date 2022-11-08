package com.chuckbuckney.arenabuddy.api;

import com.chuckbuckney.arenabuddy.model.Player;
import com.chuckbuckney.arenabuddy.service.PlayerService;

public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void addPlayer(Player player) {
        playerService.addPlayer(player);
    }
}
