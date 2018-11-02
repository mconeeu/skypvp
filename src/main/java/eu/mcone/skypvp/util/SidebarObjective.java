/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.util;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;
import eu.mcone.coresystem.api.core.gamemode.Gamemode;

public class SidebarObjective extends CoreSidebarObjective {

    public SidebarObjective() {
        super("SkyPvP");
    }

    @Override
    public void onRegister(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.1"));

        setScore(13, "");
        setScore(12, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.2"));
        setScore(11, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.3") + player.getStats(Gamemode.SKYPVP).getKill());
        setScore(10, "");
        setScore(9, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.4"));
        setScore(8, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.5") + player.getStats(Gamemode.SKYPVP).getDeath());
        setScore(7, "");
        setScore(6, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.6"));
        setScore(5, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.7")+ player.getCoins());
        setScore(4, "");
        setScore(3, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.8"));
        setScore(2, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.9"));
        setScore(1, "");
        setScore(0, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.10"));
    }

    @Override
    public void onReload(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.1"));

        setScore(11, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.3") + player.getStats(Gamemode.SKYPVP).getKill());
        setScore(8, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.5") + player.getStats(Gamemode.SKYPVP).getDeath());
        setScore(5, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.7") + player.getCoins());
        setScore(2, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.9"));
    }

}
