package com.arenabuddy.arenabuddy.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(path = "/player")
public class PlayerController {

    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Player> getAllPlayers() throws IOException {
        // This returns a JSON or XML with the users
        playerService.loadLadderData();
        return playerService.getAllPlayers();
    }

    @GetMapping(path="/load")
    public @ResponseBody void test() throws IOException {
        playerService.loadLadderData();
    }

    @GetMapping(path="/{player_name}")
    public @ResponseBody Player getPlayer(@PathVariable("player_name") String player_name) {
        return playerService.getPlayer(player_name);
    }

}
