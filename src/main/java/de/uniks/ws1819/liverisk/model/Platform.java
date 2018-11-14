package de.uniks.ws1819.liverisk.model;

import java.util.ArrayList;

public class Platform {

    private int capacity;
    private double xPos;
    private double yPos;

    // Association
    private Game game;
    private ArrayList<Unit> units = new ArrayList<>();

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getxPos() {
        return this.xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return this.yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        if(this.game == game) {
            return;
        }

        if(this.game == null && game != null) {
            this.game = game;
            this.game.addPlatform(this);
        }else if(this.game != null && game == null) {
            this.game.removePlatform(this);
            this.game = null;
        }else {
            this.game.removePlatform(this);
            this.game = game;
            this.game.addPlatform(this);
        }
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }

    public void addUnit(Unit unit) {
        if(this.units.contains(unit)) {
            return;
        }

        if(unit != null) {
            this.units.add(unit);
            unit.setPlatform(this);
        }
    }

    public void removeUnit(Unit unit) {

        if(!this.units.contains(unit)) {
            return;
        }

        this.units.remove(unit);
        unit.setPlatform(null);
    }

    public Platform withUnits(Unit unit) {
        addUnit(unit);
        return this;
    }
}
