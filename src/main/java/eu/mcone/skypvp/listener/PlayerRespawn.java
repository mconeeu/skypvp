/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.bukkit.util.LocationFactory;
import eu.mcone.skypvp.SkyPvP;
import eu.mcone.skypvp.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener{

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        SkyPvP.damager.put(p, null);

        Location respawnLocation = LocationFactory.getConfigLocation(SkyPvP.config, "Location-Spawn");
        if (respawnLocation != null) {
            e.setRespawnLocation(respawnLocation);
        } else {
            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du konntest nicht zum Spawn teleportiert werden, da der Spawn nicht eingespeichert ist!");
        }

        p.setFireTicks(0);

        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyPvP.getInstance(), () -> {
            p.getInventory().clear();
            SkyPvP.kits.resetKits(p);
            SkyPvP.kits.setKit(p, Kit.PLAYER);
        });
    }

}
