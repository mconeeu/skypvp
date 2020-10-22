/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.util;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjectiveEntry;
import eu.mcone.gameapi.api.GameAPI;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.gameapi.api.scoreboard.GameObjective;

public class SidebarObjective extends GameObjective {

    public SidebarObjective() {
        super("Ingame");
    }

    @Override
    protected void onGameObjectiveRegister(CorePlayer cp, CoreSidebarObjectiveEntry entry) {
        GamePlayer gp = GameAPI.getInstance().getGamePlayer(cp);

        entry.setScore(11, "");
        entry.setScore(10, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.2"));
        entry.setScore(9, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.3") + gp.getStats().getKills());
        entry.setScore(8, "");
        entry.setScore(7, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.4"));
        entry.setScore(6, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.5") + gp.getStats().getDeaths());
        entry.setScore(5, "");
        entry.setScore(4, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.6"));
        entry.setScore(3, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.7") + cp.getCoins());
        entry.setScore(2, "");
        entry.setScore(1, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.8"));
        entry.setScore(0, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.9"));
    }

    @Override
    protected void onGameObjectiveReload(CorePlayer cp, CoreSidebarObjectiveEntry entry) {
        GamePlayer gp = GameAPI.getInstance().getGamePlayer(cp);

        entry.setScore(9, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.3") + gp.getStats().getKills());
        entry.setScore(6, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.5") + gp.getStats().getDeaths());
        entry.setScore(3, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.7") + cp.getCoins());
        entry.setScore(0, CoreSystem.getInstance().getTranslationManager().get("skypvp.scoreboard.9"));
    }

}
