package com.arenabuddy.arenabuddy.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    /*public List<Player> getPlayers() {
        return List.of(
                new Player(
                        1,
                        300,
                        "Ventition",
                        60,
                        "Feral",
                        "Druid",
                        "Area 52"
                )
        );
    }*/

    public void addPlayer(Player player_request) {
        Player n = new Player();
        n.setPlayer_name(player_request.getPlayer_name());
        n.setPlayer_rank(player_request.getPlayer_rank());
        n.setPlayer_rating(player_request.getPlayer_rating());
        n.setPlayer_level(player_request.getPlayer_level());
        n.setPlayer_spec(player_request.getPlayer_spec());
        n.setPlayer_wowclass(player_request.getPlayer_wowclass());
        n.setPlayer_realm(player_request.getPlayer_realm());
        playerRepository.save(n);
    }

    public Iterable<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
