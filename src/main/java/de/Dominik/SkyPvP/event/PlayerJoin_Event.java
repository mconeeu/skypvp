/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.event;

import de.Dominik.BukkitCoreSystem.util.LocationFactory;
import de.Dominik.SkyPvP.Main;
import de.Dominik.SkyPvP.scoreboard.Scoreboard;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin_Event implements Listener{

	@EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();
    
        new Scoreboard(p);

        Location spawn = LocationFactory.getConfigLocation(Main.config, "Location-Spawn");

        if (spawn != null) {
            p.teleport(spawn);
        } else if(p.hasPermission("group.admin")) {
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Der Spawn wurde noch nicht gesetzt!");
        }
       
        e.setJoinMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Join").replaceAll("%Player%", p.getName()));

        p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 1.0F);
        p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10);
    }
}
