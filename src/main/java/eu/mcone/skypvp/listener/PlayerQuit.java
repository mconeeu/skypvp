/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener{
	
	@EventHandler
	public void on(PlayerQuitEvent e){
		Player p = e.getPlayer();
		e.setQuitMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Quit").replaceAll("%Player%", p.getName()));
	}

}
