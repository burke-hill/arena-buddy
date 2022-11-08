package com.chuckbuckney.arenabuddy.service;

import com.chuckbuckney.arenabuddy.dao.PlayerDao;
import com.chuckbuckney.arenabuddy.model.Player;

public class PlayerService {

    private final PlayerDao playerDao;

    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public int addPlayer(Player player) {
        return playerDao.insertPlayer(player);
    }
}
