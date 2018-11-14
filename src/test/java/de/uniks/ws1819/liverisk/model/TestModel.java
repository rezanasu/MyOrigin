package de.uniks.ws1819.liverisk.model;

import org.junit.Assert;
import org.junit.Test;

public class TestModel {

        // standsOn (Unit - Platform * - 1)

        @Test
        public void unitPlatformAssoc() {
           Platform platform = new Platform();

           Unit unitOne = new Unit();
           Unit unitTwo = new Unit();

            unitOne.setPlatform(platform);
            unitTwo.setPlatform(platform);

            Assert.assertEquals(unitOne.getPlatform(), platform);
            Assert.assertEquals(unitTwo.getPlatform(), platform);
            Assert.assertEquals(platform.getUnits().size(), 2);

            unitOne.setPlatform(null);

            Assert.assertEquals(platform.getUnits().size(), 1);
            Assert.assertEquals(unitOne.getPlatform(), null);
        }

        @Test
        public void platformUnitAssoc(){
            Platform p1 = new Platform();
            Platform p2 = new Platform();

            Unit unitOne = new Unit();
            Unit unitTwo = new Unit();
            Unit unitThree = new Unit();

            p1.addUnit(unitOne);
            p1.addUnit(unitTwo);
            p2.addUnit(unitThree);

            Assert.assertEquals(unitOne.getPlatform(), p1);
            Assert.assertEquals(unitThree.getPlatform(), p2);

            Assert.assertEquals(p1.getUnits().size(), 2);

            p1.removeUnit(unitTwo);
            Assert.assertEquals(unitTwo.getPlatform(), null);
            Assert.assertEquals(p1.getUnits().size(), 1);

        }

        // units (Player - Unit 1 - *)

        @Test
        public void unitPlayerAssoc() {
            Player sam = new Player();

            Unit dragon = new Unit();
            Unit cavalry = new Unit();

            dragon.setPlayer(sam);
            cavalry.setPlayer(sam);

            Assert.assertEquals(dragon.getPlayer(), sam);
            Assert.assertEquals(cavalry.getPlayer(), sam);
            Assert.assertEquals(sam.getUnits().size(), 2);

            dragon.setPlayer(null);

            Assert.assertEquals(dragon.getPlayer(), null);
            Assert.assertTrue(!sam.getUnits().contains(dragon));
            Assert.assertTrue(sam.getUnits().contains(cavalry));
            Assert.assertEquals(sam.getUnits().size(), 1);

        }

        @Test
        public void playerUnitAssoc() {
            Player sam = new Player();
            Player alex = new Player();

            sam.setName("Sam");
            alex.setName("Alex");

            Assert.assertEquals(sam.getName(), "Sam");
            Assert.assertEquals(alex.getName(), "Alex");

            Unit archer = new Unit();
            Unit pikemen = new Unit();
            Unit knight = new Unit();
            Unit swordsman = new Unit();

            sam.addUnit(archer);
            sam.addUnit(pikemen);

            alex.addUnit(knight);
            alex.addUnit(swordsman);

            Assert.assertEquals(sam.getUnits().size(), 2);
            Assert.assertEquals(alex.getUnits().size(), 2);

            alex.removeUnit(knight);

            Assert.assertEquals(knight.getPlayer(), null);
            Assert.assertTrue(!alex.getUnits().contains(knight));
            Assert.assertEquals(alex.getUnits().size(), 1);

            sam.removeUnit(archer);
            sam.removeUnit(pikemen);

            Assert.assertEquals(sam.getUnits().size(), 0);

        }

        // players (Game - Player 1 - *)

        @Test
        public void gamePlayerAssoc() {
            Game risk = new Game();

            Player jasmine = new Player();
            Player sandro = new Player();

            risk.addPlayer(jasmine);
            risk.addPlayer(sandro);

            Assert.assertEquals(jasmine.getGame(), risk);
            Assert.assertEquals(sandro.getGame(), risk);
            Assert.assertEquals(risk.getPlayers().size(), 2);

            risk.removePlayer(sandro);
            Assert.assertEquals(sandro.getGame(), null);
            Assert.assertTrue(!risk.getPlayers().contains(sandro));
            Assert.assertEquals(risk.getPlayers().size(), 1);

            Player sara = new Player();

            risk.addPlayer(sara);
            Assert.assertEquals(sara.getGame(), risk);
            Assert.assertEquals(risk.getPlayers().size(), 2);
        }

        @Test
        public void playerGameAssoc() {
            Game risk = new Game();

            Player sara = new Player();
            Player jasmine = new Player();

            sara.setGame(risk);
            jasmine.setGame(risk);

            Assert.assertEquals(sara.getGame(), risk);
            Assert.assertEquals(jasmine.getGame(), risk);
            Assert.assertEquals(risk.getPlayers().size(), 2);

            jasmine.setGame(null);

            Assert.assertEquals(jasmine.getGame(), null);
            Assert.assertFalse(risk.getPlayers().contains(jasmine));
            Assert.assertEquals(risk.getPlayers().size(), 1);
        }





}
