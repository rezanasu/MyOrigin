package de.uniks.ws1819.liverisk.model;

public class Unit {

    // Association
    private Platform platform;
    private Player player;

    public Platform getPlatform() {
        return this.platform;
    }

    public void setPlatform(Platform platform) {
        if(this.platform == platform) {
            return;
        }

        if(this.platform == null && platform != null) {
            this.platform = platform;
            this.platform.addUnit(this);
        }else if(this.platform != null && platform == null) {
            this.platform.removeUnit(this);
            this.platform = null;
        }
        else {
            this.platform.removeUnit(this);
            this.platform = platform;
            this.platform.addUnit(this);
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        if(this.player == player) {
            return;
        }

        if(this.player == null && player != null) {
            this.player = player;
            this.player.addUnit(this);
        }else if(this.player != null && player == null) {
            this.player.removeUnit(this);
            this.player = null;
        }
        else {
            this.player.removeUnit(this);
            this.player = player;
            this.player.addUnit(this);
        }
    }


}
