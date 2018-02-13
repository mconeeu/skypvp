/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.bukkit.event.StatsChangeEvent;
import eu.mcone.coresystem.bukkit.player.CorePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;

import static eu.mcone.coresystem.bukkit.CoreSystem.statsSkypvp;

public class StatsChange implements Listener {

    @EventHandler
    public void on(StatsChangeEvent e) {
        CorePlayer p = e.getPlayer();

        if (e.getStats().equals(statsSkypvp)) {
            p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
        }
    }

}
