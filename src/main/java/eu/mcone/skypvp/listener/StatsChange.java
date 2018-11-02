/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.event.StatsChangeEvent;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;

public class StatsChange implements Listener {

    @EventHandler
    public void on(StatsChangeEvent e) {
        CorePlayer p = e.getPlayer();
        p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
    }

}
