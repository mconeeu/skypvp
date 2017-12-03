/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.event;

import eu.mcone.bukkitcoresystem.util.LocationFactory;
import eu.mcone.skypvp.Main;
import eu.mcone.skypvp.kit.Kit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn_Event implements Listener{

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        p.getInventory().clear();
        Main.kits.resetKits(p);
        Main.kits.setKit(p, Kit.PLAYER);

        Location respawnLocation = LocationFactory.getConfigLocation(Main.config, "Location-Spawn");
        if (respawnLocation != null) {
            e.setRespawnLocation(respawnLocation);
        } else {
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du konntest nicht zum Spawn teleportiert werden, da der Spawn nicht eingespeichert ist!");
        }
    }

}
