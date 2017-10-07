package me.SkyPvP.Event.de;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakEvent_EVENT implements Listener{

	@EventHandler
	public void on(BlockBreakEvent e){
		Player p = e.getPlayer();
		
		if(!(p.getGameMode() == GameMode.SURVIVAL)){
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}
}
