package de.Dominik.SkyPvP.Event;

import de.Dominik.SkyPvP.Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class PlayerBedEnterEvent_EVENT implements Listener{

	@EventHandler
    public void onbed(PlayerBedEnterEvent e){
    	Player p = e.getPlayer();
    	e.setCancelled(true);
    	p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §cHier darf man kein Bed benutzen!");
    		
    }
}
