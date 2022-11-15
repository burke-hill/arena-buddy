package com.arenabuddy.arenabuddy.player;

public class Player {

    final private int rank;
    final private int rating;
    final private String name;
    final private int level;
    final private String spec;
    final private String wowClass;
    final private String realm;

    // player object constructor
    public Player(int rank, int rating, String name, int level, String spec, String wowClass, String realm) {
        this.rank = rank;
        this.rating = rating;
        this.name = name;
        this.level = level;
        this.spec = spec;
        this.wowClass = wowClass;
        this.realm = realm;
    }



    public int getRank() {
        return this.rank;
    }

    public int getRating() {
        return this.rating;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public String getSpec() {
        return this.spec;
    }

    public String getWowClass() {
        return this.wowClass;
    }

    public String getRealm() {
        return this.realm;
    }

    @Override
    public String toString() {
        return "Player{" +
                "rank=" + rank +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", spec='" + spec + '\'' +
                ", wowClass='" + wowClass + '\'' +
                ", realm='" + realm + '\'' +
                '}';
    }
}
