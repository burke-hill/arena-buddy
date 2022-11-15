package com.arenabuddy.arenabuddy.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping(path = "/arenaladder")
public class PlayerController {

    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewPlayer (@RequestBody Player player_request) {
        playerService.addPlayer(player_request);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Player> getAllPlayers() {
        // This returns a JSON or XML with the users
        return playerService.getAllPlayers();
    }

}
