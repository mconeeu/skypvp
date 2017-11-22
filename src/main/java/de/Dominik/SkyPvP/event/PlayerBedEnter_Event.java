/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.event;

import de.Dominik.SkyPvP.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class PlayerBedEnter_Event implements Listener{

	@EventHandler
    public void on(PlayerBedEnterEvent e){
    	Player p = e.getPlayer();
    	e.setCancelled(true);
    	p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§cHier darf man kein Bett benutzen!");
    		
    }
}