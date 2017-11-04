/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald, BamDev and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.scoreboard;

import de.Dominik.BukkitCoreSystem.api.CoinsAPI;
import de.Dominik.SkyPvP.Main;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import java.util.HashMap;

import static de.Dominik.BukkitCoreSystem.Main.statsSkypvp;

public class Scoreboard {

    private Player p;
    private org.bukkit.scoreboard.Scoreboard sb;
    private Objective o;
    private HashMap<String, Integer> scores;

    public Scoreboard(Player p) {
        this.p = p;
        this.scores = new HashMap<>();
        ScoreboardManager.scoreboards.add(this);

        int kills = statsSkypvp.getKills(p.getUniqueId().toString(), p.getName());
        int tode = statsSkypvp.getDeaths(p.getUniqueId().toString(), p.getName());
        int coins = CoinsAPI.getCoins(p);

        Objective old = p.getScoreboard().getObjective(DisplaySlot.SIDEBAR);
        if (old != null) {
            old.unregister();
        }

        this.sb = p.getScoreboard();
        this.o = sb.registerNewObjective("Main", "SkyPvP");

        this.o.setDisplaySlot(DisplaySlot.SIDEBAR);
        this.o.setDisplayName(Main.config.getConfigValue("ScoreBoard-1"));

        this.o.getScore(Main.config.getConfigValue("ScoreBoard-2")).setScore(11);
        this.scores.put(Main.config.getConfigValue("ScoreBoard-3")+ kills, 10);
        this.o.getScore("§1").setScore(9);
        this.o.getScore(Main.config.getConfigValue("ScoreBoard-4")).setScore(8);
        this.scores.put(Main.config.getConfigValue("ScoreBoard-5") + tode, 7);
        this.o.getScore("§2").setScore(6);
        this.o.getScore(Main.config.getConfigValue("ScoreBoard-6")).setScore(5);
        this.scores.put(Main.config.getConfigValue("ScoreBoard-7")+ coins, 4);
        this.o.getScore("§3").setScore(3);
        this.o.getScore(Main.config.getConfigValue("ScoreBoard-8")).setScore(2);
        this.scores.put(Main.config.getConfigValue("ScoreBoard-9"), 1);
        this.o.getScore("§4").setScore(0);

        for (HashMap.Entry<String, Integer> entry : this.scores.entrySet()) {
            String s = entry.getKey();
            int score = entry.getValue();

            this.o.getScore(s).setScore(score);
        }

        p.setScoreboard(this.sb);
    }

    void updateScoreboard() {
        String _10 = Main.config.getConfigValue("ScoreBoard-3")+statsSkypvp.getKills(p.getUniqueId().toString(), p.getName());
        String _7 = Main.config.getConfigValue("ScoreBoard-5")+statsSkypvp.getDeaths(p.getUniqueId().toString(), p.getName());
        String _4 = Main.config.getConfigValue("ScoreBoard-7")+CoinsAPI.getCoins(p);
        String _1 = Main.config.getLiveConfigValue("ScoreBoard-9");

        for (HashMap.Entry<String, Integer> entry : this.scores.entrySet()) {
            String s = entry.getKey();
            this.sb.resetScores(s);
        }
        this.scores = new HashMap<>();

        this.scores.put(_10, 10);
        this.scores.put(_7, 7);
        this.scores.put(_4, 4);
        this.scores.put(_1, 1);

        for (HashMap.Entry<String, Integer> entry : this.scores.entrySet()) {
            String s = entry.getKey();
            int score = entry.getValue();

            this.o.getScore(s).setScore(score);
        }

        this.p.setScoreboard(sb);
    }
}
