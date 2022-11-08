package com.chuckbuckney.arenabuddy.dao;

import com.chuckbuckney.arenabuddy.model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class FakePlayerDataAccessService implements PlayerDao {

    private static List<Player> DB = new ArrayList<>();


    @Override
    public int insertPlayer(int rank, int rating, String name, int level, String spec, String wowClass, String realm) {
        DB.add(new Player(rank, rating, name, level, spec, wowClass, realm));
        return 1;
    }

    @Override
    public int insertPlayer(Player player) {
        return 0;
    }
}
