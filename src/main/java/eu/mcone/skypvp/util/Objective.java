/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.util;

import eu.mcone.bukkitcoresystem.api.CoinsAPI;
import eu.mcone.bukkitcoresystem.player.CorePlayer;
import eu.mcone.bukkitcoresystem.scoreboard.ObjectiveHandler;
import eu.mcone.skypvp.Main;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import static eu.mcone.bukkitcoresystem.CoreSystem.statsSkypvp;

public class Objective implements ObjectiveHandler {

    public Objective(CorePlayer p) {
        p.getScoreboard().setNewObjective(DisplaySlot.SIDEBAR, this, "Main", "SkyPvP");
    }

    @Override
    public void register(CorePlayer corePlayer, Scoreboard scoreboard) {
        org.bukkit.scoreboard.Objective objective = scoreboard.getObjective(DisplaySlot.SIDEBAR);

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(Main.config.getConfigValue("ScoreBoard-1"));

        if (scoreboard.getTeam("kills") != null) scoreboard.getTeam("kills").unregister();
        if (scoreboard.getTeam("deaths") != null) scoreboard.getTeam("deaths").unregister();
        if (scoreboard.getTeam("coins") != null) scoreboard.getTeam("coins").unregister();

        Team kills = scoreboard.registerNewTeam("kills");
        kills.addEntry("§1");
        kills.setPrefix(Main.config.getConfigValue("ScoreBoard-3") + statsSkypvp.getKills(corePlayer.getUuid()));

        Team deaths = scoreboard.registerNewTeam("deaths");
        deaths.addEntry("§3");
        deaths.setPrefix(Main.config.getConfigValue("ScoreBoard-5") + statsSkypvp.getDeaths(corePlayer.getUuid()));

        Team coins = scoreboard.registerNewTeam("coins");
        coins.addEntry("§5");
        coins.setPrefix(Main.config.getConfigValue("ScoreBoard-7")+ CoinsAPI.getCoins(corePlayer.getUuid()));

        objective.getScore("§0").setScore(13);
        objective.getScore(Main.config.getConfigValue("ScoreBoard-2")).setScore(12);
        objective.getScore("§1").setScore(11);
        objective.getScore("§2").setScore(10);
        objective.getScore(Main.config.getConfigValue("ScoreBoard-4")).setScore(9);
        objective.getScore("§3").setScore(8);
        objective.getScore("§4").setScore(7);
        objective.getScore(Main.config.getConfigValue("ScoreBoard-6")).setScore(6);
        objective.getScore("§5").setScore(5);
        objective.getScore("§6").setScore(4);
        objective.getScore(Main.config.getConfigValue("ScoreBoard-8")).setScore(3);
        objective.getScore(Main.config.getLiveConfigValue("ScoreBoard-9")).setScore(2);
        objective.getScore("§7").setScore(1);
        objective.getScore(Main.config.getConfigValue("ScoreBoard-10")).setScore(0);

        corePlayer.bukkit().setScoreboard(scoreboard);
    }

    @Override
    public void reload(CorePlayer corePlayer, Scoreboard scoreboard) {
        scoreboard.getObjective(DisplaySlot.SIDEBAR).setDisplayName(Main.config.getLiveConfigValue("ScoreBoard-1"));

        scoreboard.getTeam("kills").setPrefix(Main.config.getConfigValue("ScoreBoard-3") + statsSkypvp.getKills(corePlayer.getUuid()));
        scoreboard.getTeam("deaths").setPrefix(Main.config.getConfigValue("ScoreBoard-5") + statsSkypvp.getDeaths(corePlayer.getUuid()));
        scoreboard.getTeam("coins").setPrefix(Main.config.getConfigValue("ScoreBoard-7") + CoinsAPI.getCoins(corePlayer.getUuid()));

        String event = Main.config.getLiveConfigValue("ScoreBoard-9");
        scoreboard.resetScores(event);
        scoreboard.getObjective(DisplaySlot.SIDEBAR).getScore(event).setScore(2);

        corePlayer.bukkit().setScoreboard(scoreboard);
    }

}
