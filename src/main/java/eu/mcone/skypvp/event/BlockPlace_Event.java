/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.event;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace_Event implements Listener{

	@EventHandler
	public void on(BlockPlaceEvent e){
		Player p = e.getPlayer();
		
		if(p.getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}
}