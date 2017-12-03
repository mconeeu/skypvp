/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.util;

import eu.mcone.bukkitcoresystem.api.CoinsAPI;
import eu.mcone.skypvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

import java.util.Collection;

import static eu.mcone.bukkitcoresystem.Main.statsSkypvp;


public class Scoreboard {

    private static String event = "";

    public static void setObjective(Player p) {
        Objective old = p.getScoreboard().getObjective(DisplaySlot.SIDEBAR);
        if (old != null) {
            old.unregister();
        }

        org.bukkit.scoreboard.Scoreboard sb = p.getScoreboard();
        Objective o = sb.registerNewObjective("Main", "SkyPvP");

        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(Main.config.getConfigValue("ScoreBoard-1"));

        if (sb.getTeam("kills") != null) sb.getTeam("kills").unregister();
        if (sb.getTeam("deaths") != null) sb.getTeam("deaths").unregister();
        if (sb.getTeam("coins") != null) sb.getTeam("coins").unregister();

        Team kills = sb.registerNewTeam("kills");
        kills.addEntry("§1");
        kills.setPrefix(Main.config.getConfigValue("ScoreBoard-3") + statsSkypvp.getKills(p.getUniqueId().toString(), p.getName()));

        Team deaths = sb.registerNewTeam("deaths");
        deaths.addEntry("§3");
        deaths.setPrefix(Main.config.getConfigValue("ScoreBoard-5") + statsSkypvp.getDeaths(p.getUniqueId().toString(), p.getName()));

        Team coins = sb.registerNewTeam("coins");
        coins.addEntry("§5");
        coins.setPrefix(Main.config.getConfigValue("ScoreBoard-7")+ CoinsAPI.getCoins(p));

        event = Main.config.getLiveConfigValue("ScoreBoard-9");

        o.getScore("§0").setScore(13);
        o.getScore(Main.config.getConfigValue("ScoreBoard-2")).setScore(12);
        o.getScore("§1").setScore(11);
        o.getScore("§2").setScore(10);
        o.getScore(Main.config.getConfigValue("ScoreBoard-4")).setScore(9);
        o.getScore("§3").setScore(8);
        o.getScore("§4").setScore(7);
        o.getScore(Main.config.getConfigValue("ScoreBoard-6")).setScore(6);
        o.getScore("§5").setScore(5);
        o.getScore("§6").setScore(4);
        o.getScore(Main.config.getConfigValue("ScoreBoard-8")).setScore(3);
        o.getScore(event).setScore(2);
        o.getScore("§7").setScore(1);
        o.getScore(Main.config.getConfigValue("ScoreBoard-10")).setScore(0);

        p.setScoreboard(sb);
    }

    public static void startUpdateScoreboardScheduler() {
        Bukkit.getScheduler().runTaskTimer(Main.getInstance(), () -> {
            Collection<? extends Player> online = Bukkit.getOnlinePlayers();

            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
                boolean eventChamged = false;
                String newEvent = Main.config.getLiveConfigValue("ScoreBoard-9");
                if (!event.equals(newEvent)) eventChamged = true;

                for(Player p : online) {
                    org.bukkit.scoreboard.Scoreboard sb = p.getScoreboard();
                    sb.getObjective(DisplaySlot.SIDEBAR).setDisplayName(Main.config.getLiveConfigValue("ScoreBoard-1"));

                    sb.getTeam("kills").setPrefix(Main.config.getConfigValue("ScoreBoard-3") + statsSkypvp.getKills(p.getUniqueId().toString(), p.getName()));
                    sb.getTeam("deaths").setPrefix(Main.config.getConfigValue("ScoreBoard-5") + statsSkypvp.getDeaths(p.getUniqueId().toString(), p.getName()));
                    sb.getTeam("coins").setPrefix(Main.config.getConfigValue("ScoreBoard-7") + CoinsAPI.getCoins(p));

                    String event = Main.config.getLiveConfigValue("ScoreBoard-9");
                    if (eventChamged) {
                        sb.resetScores(event);
                        sb.getObjective(DisplaySlot.SIDEBAR).getScore(event).setScore(2);
                    }

                    p.setScoreboard(sb);
                }

                event = newEvent;
            });
        }, 100L, 20L);
    }
}
