/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.bukkitcoresystem.util.LocationFactory;
import eu.mcone.skypvp.Main;
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
        Main.damager.put(p, null);

        Location respawnLocation = LocationFactory.getConfigLocation(Main.config, "Location-Spawn");
        if (respawnLocation != null) {
            e.setRespawnLocation(respawnLocation);
        } else {
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du konntest nicht zum Spawn teleportiert werden, da der Spawn nicht eingespeichert ist!");
        }

        p.setFireTicks(0);

        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            p.getInventory().clear();
            Main.kits.resetKits(p);
            Main.kits.setKit(p, Kit.PLAYER);
        });
    }

}
