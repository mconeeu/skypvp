/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.bukkitcoresystem.CoreSystem;
import eu.mcone.bukkitcoresystem.util.LocationFactory;
import eu.mcone.skypvp.Main;
import eu.mcone.skypvp.kit.Kit;
import eu.mcone.skypvp.util.Objective;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener{

	@EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        Location spawn = LocationFactory.getConfigLocation(Main.config, "Location-Spawn");
        if (spawn != null) {
            p.teleport(spawn);
        } else if(p.hasPermission("group.admin")) {
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Der Spawn wurde noch nicht gesetzt!");
        }
       
        e.setJoinMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Join").replaceAll("%Player%", p.getName()));

        new Objective(CoreSystem.getCorePlayer(p));

        if (hasEmptyInventory(p)) {
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du scheinst neu auf SkyPvP zu sein! Du bekommst das Standart-Kit!");
            Main.kits.setKit(p, Kit.PLAYER);
        }

        p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10);
    }

    private boolean hasEmptyInventory(Player p) {
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null) {
                return false;
            }
        }
        return true;
    }
}
