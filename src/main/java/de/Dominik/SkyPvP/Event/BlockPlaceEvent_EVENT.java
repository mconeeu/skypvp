package me.SkyPvP.Event.de;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceEvent_EVENT implements Listener{

	@EventHandler
	public void on(BlockPlaceEvent e){
		Player p = e.getPlayer();
		
		if(!(p.getGameMode() == GameMode.SURVIVAL)){
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}
}
