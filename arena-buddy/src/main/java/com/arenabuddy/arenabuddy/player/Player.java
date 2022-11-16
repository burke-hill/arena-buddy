package com.arenabuddy.arenabuddy.player;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    private String player_name;
    private int player_rank;
    private int player_rating;
    private int player_level;
    private String player_spec;
    private String player_wowclass;
    private String player_realm;


// player object constructor

    public String getPlayer_name() {
        return player_name;
    }

    public int getPlayer_rank() {
        return player_rank;
    }

    public int getPlayer_rating() {
        return player_rating;
    }

    public int getPlayer_level() {
        return player_level;
    }

    public String getPlayer_spec() {
        return player_spec;
    }

    public String getPlayer_wowclass() {
        return player_wowclass;
    }

    public String getPlayer_realm() {
        return player_realm;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public void setPlayer_rank(int player_rank) {
        this.player_rank = player_rank;
    }

    public void setPlayer_rating(int player_rating) {
        this.player_rating = player_rating;
    }

    public void setPlayer_level(int player_level) {
        this.player_level = player_level;
    }

    public void setPlayer_spec(String player_spec) {
        this.player_spec = player_spec;
    }

    public void setPlayer_wowclass(String player_wowclass) {
        this.player_wowclass = player_wowclass;
    }

    public void setPlayer_realm(String player_realm) {
        this.player_realm = player_realm;
    }

    @Override
    public String toString() {
        return "Player{" +
                "rank=" + player_rank +
                ", rating=" + player_rating +
                ", name='" + player_name + '\'' +
                ", level=" + player_level +
                ", spec='" + player_spec + '\'' +
                ", wowClass='" + player_wowclass + '\'' +
                ", realm='" + player_realm + '\'' +
                '}';
    }
}

