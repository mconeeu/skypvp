/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.SkyPvP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener{
	
	@EventHandler
	public void on(PlayerQuitEvent e){
		Player p = e.getPlayer();
		p.setLevel(0);
		e.setQuitMessage(SkyPvP.config.getConfigValue("System-Prefix") + SkyPvP.config.getConfigValue("System-Quit").replaceAll("%Player%", p.getName()));
	}

}
