/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.util;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjectiveEntry;

public class SidebarObjective extends CoreSidebarObjective {

    public SidebarObjective() {
        super("SkyPvP");
    }

    @Override
    protected void onRegister(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        entry.setTitle(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.1"));

        entry.setScore(13, "");
        entry.setScore(12, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.2"));
        entry.setScore(11, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.3") + player.getStats(Gamemode.SKYPVP).getKill());
        entry.setScore(10, "");
        entry.setScore(9, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.4"));
        entry.setScore(8, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.5") + player.getStats(Gamemode.SKYPVP).getDeath());
        entry.setScore(7, "");
        entry.setScore(6, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.6"));
        entry.setScore(5, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.7") + player.getCoins());
        entry.setScore(4, "");
        entry.setScore(3, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.8"));
        entry.setScore(2, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.9"));
        entry.setScore(1, "");
        entry.setScore(0, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.10"));
    }

    @Override
    protected void onReload(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        entry.setTitle(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.1"));

        entry.setScore(11, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.3") + player.getStats(Gamemode.SKYPVP).getKill());
        entry.setScore(8, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.5") + player.getStats(Gamemode.SKYPVP).getDeath());
        entry.setScore(5, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.7") + player.getCoins());
        entry.setScore(2, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.9"));
    }
}
