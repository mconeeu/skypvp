/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.SkyPvP;
import eu.mcone.skypvp.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener{

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        SkyPvP.damager.put(p, null);

        SkyPvP.getInstance().getLocationManager().teleport(p, "spawn");

        p.setFireTicks(0);

        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyPvP.getInstance(), () -> {
            p.getInventory().clear();
            SkyPvP.getInstance().getKitManager().resetKits(p);
            SkyPvP.getInstance().getKitManager().setKit(p, Kit.PLAYER);
        });
    }

}
