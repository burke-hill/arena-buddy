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
    private PlayerRepository playerRepository;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewPlayer (@RequestBody Player player_request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Player n = new Player();
        n.setPlayer_name(player_request.getPlayer_name());
        n.setPlayer_rank(player_request.getPlayer_rank());
        n.setPlayer_rating(player_request.getPlayer_rating());
        n.setPlayer_level(player_request.getPlayer_level());
        n.setPlayer_spec(player_request.getPlayer_spec());
        n.setPlayer_wowclass(player_request.getPlayer_wowclass());
        n.setPlayer_realm(player_request.getPlayer_realm());
        playerRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Player> getAllPlayers() {
        // This returns a JSON or XML with the users
        return playerRepository.findAll();
    }

}
