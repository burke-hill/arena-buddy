package com.chuckbuckney.arenabuddy.dao;

import com.chuckbuckney.arenabuddy.model.Player;

public interface PlayerDao {

    int insertPlayer(int rank, int rating, String name, int level, String spec, String wowClass, String realm);

    int insertPlayer(Player player);
}
