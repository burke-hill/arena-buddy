package com.chuckbuckney.arenabuddy.model;

public class Player {

    private final int rank;
    private final int rating;
    private final String name;
    private final int level;
    private final String spec;
    private final String wowClass;
    private final String realm;

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


}