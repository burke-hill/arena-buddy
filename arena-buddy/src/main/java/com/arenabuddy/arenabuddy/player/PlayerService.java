package com.arenabuddy.arenabuddy.player;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    public List<Player> getPlayers() {
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
    }
}
