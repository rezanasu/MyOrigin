package de.uniks.ws1819.liverisk.model;

import java.util.ArrayList;

public class Player {

    private String name;
    private String color;

    // Association
    private Game game;
    private ArrayList<Unit> units = new ArrayList<>();


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
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
            this.game.addPlayer(this);
        }else if(this.game != null && game == null) {
            this.game.removePlayer(this);
            this.game = null;
        }else {
            this.game.removePlayer(this);
            this.game = game;
            this.game.addPlayer(this);
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
            unit.setPlayer(this);
        }
    }

    public void removeUnit(Unit unit) {
        if(!this.units.contains(unit)) {
            return;
        }

        this.units.remove(unit);
        unit.setPlayer(null);
    }

    public Player withUnits(Unit unit) {
        addUnit(unit);
        return this;
    }


}
