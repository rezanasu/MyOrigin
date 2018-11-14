package de.uniks.ws1819.liverisk.model;

import java.util.ArrayList;

public class Game {

    private String name;

    // Association
    private ArrayList<Platform> platforms = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlatform(Platform platform) {
        if(platforms.contains(platform)) {
            return;
        }
        if(platform != null) {
            platforms.add(platform);
            platform.setGame(this);
        }

    }

    public void removePlatform(Platform platform) {
        if(!platforms.contains(platform)) {
            return;
        }
        platforms.remove(platform);
        platform.setGame(null);
    }

    public Game withPlatforms(Platform platform){
        addPlatform(platform);
        return this;
    }

    public void addPlayer(Player player) {
       if(players.contains(player)) {
           return;
       }
        // If player exist
       if(player != null) {
           players.add(player);
           player.setGame(this);
       }

    }

    public void removePlayer(Player player) {
        if(!players.contains(player)) {
            return;
        }
        players.remove(player);
        player.setGame(null);
    }

    public Game withPlayer(Player player) {
        addPlayer(player);
        return this;
    }



}
