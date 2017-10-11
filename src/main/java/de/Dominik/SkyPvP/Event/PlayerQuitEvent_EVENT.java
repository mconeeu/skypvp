package de.Dominik.SkyPvP.Event;

import de.Dominik.SkyPvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEvent_EVENT implements Listener{
	
	@EventHandler
	public void OnQuit(PlayerQuitEvent e){
	Player p = e.getPlayer();
		e.setQuitMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " " + Main.cfg.getString("SkyPvP.Quit").replaceAll("&", "§").replaceAll(">", "»").replaceAll("%Player%", p.getName()));
	}

}
