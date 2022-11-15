package com.arenabuddy.arenabuddy.player;

import org.springframework.data.repository.CrudRepository;

import com.arenabuddy.arenabuddy.player.Player;

public interface PlayerRepository extends CrudRepository<Player, String> {

}
