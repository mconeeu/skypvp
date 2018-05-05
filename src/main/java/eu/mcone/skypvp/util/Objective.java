/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.util;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreObjective;
import eu.mcone.coresystem.api.core.gamemode.Gamemode;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Team;

public class Objective extends CoreObjective {

    public Objective() {
        super(DisplaySlot.SIDEBAR, "SkyPvP", "SkyPvP");
    }

    @Override
    public void register() {
        objective.setDisplayName(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.1"));

        if (scoreboard.getTeam("kills") != null) scoreboard.getTeam("kills").unregister();
        if (scoreboard.getTeam("deaths") != null) scoreboard.getTeam("deaths").unregister();
        if (scoreboard.getTeam("coins") != null) scoreboard.getTeam("coins").unregister();

        Team kills = scoreboard.registerNewTeam("kills");
        kills.addEntry("§1");
        kills.setPrefix(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.3") + CoreSystem.getInstance().getStatsAPI(Gamemode.SKYPVP).getKills(player.getUuid()));

        Team deaths = scoreboard.registerNewTeam("deaths");
        deaths.addEntry("§3");
        deaths.setPrefix(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.5") + CoreSystem.getInstance().getStatsAPI(Gamemode.SKYPVP).getDeaths(player.getUuid()));

        Team coins = scoreboard.registerNewTeam("coins");
        coins.addEntry("§5");
        coins.setPrefix(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.7")+ CoreSystem.getInstance().getCoinsAPI().getCoins(player.getUuid()));

        objective.getScore("§0").setScore(13);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.2")).setScore(12);
        objective.getScore("§1").setScore(11);
        objective.getScore("§2").setScore(10);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.4")).setScore(9);
        objective.getScore("§3").setScore(8);
        objective.getScore("§4").setScore(7);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.6")).setScore(6);
        objective.getScore("§5").setScore(5);
        objective.getScore("§6").setScore(4);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.8")).setScore(3);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.9")).setScore(2);
        objective.getScore("§7").setScore(1);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.10")).setScore(0);

        player.bukkit().setScoreboard(scoreboard);
    }

    @Override
    public void reload() {
        objective.setDisplayName(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.1"));

        scoreboard.getTeam("kills").setPrefix(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.3") + CoreSystem.getInstance().getStatsAPI(Gamemode.SKYPVP).getKills(player.getUuid()));
        scoreboard.getTeam("deaths").setPrefix(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.5") + CoreSystem.getInstance().getStatsAPI(Gamemode.SKYPVP).getDeaths(player.getUuid()));
        scoreboard.getTeam("coins").setPrefix(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.7") + CoreSystem.getInstance().getCoinsAPI().getCoins(player.getUuid()));

        String event = CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.9");
        scoreboard.resetScores(event);
        scoreboard.getObjective(DisplaySlot.SIDEBAR).getScore(event).setScore(2);

        player.bukkit().setScoreboard(scoreboard);
    }

}
