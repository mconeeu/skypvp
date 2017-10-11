package de.Dominik.SkyPvP.Listener;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class Shop_LISTENER implements Listener{
 
	@EventHandler
	public void onVillager(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		
		if(e.getRightClicked() instanceof Villager) {
			Villager i = (Villager) e.getRightClicked();
			e.setCancelled(true);
			
			if(i.getCustomName().equalsIgnoreCase("§9SkyPvP §8» §cShop")) {
				i.setCustomNameVisible(true);
				p.performCommand("shop");
			}
		}
		
	}
}
