package me.SkyPvP.Event.de;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import me.SkyPvP.Main.de.Main;

public class PlayerBedEnterEvent_EVENT implements Listener{

	@EventHandler
    public void onbed(PlayerBedEnterEvent e){
    	Player p = e.getPlayer();
    	e.setCancelled(true);
    	p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §cHier darf man kein Bed benutzen!");
    		
    }
}
