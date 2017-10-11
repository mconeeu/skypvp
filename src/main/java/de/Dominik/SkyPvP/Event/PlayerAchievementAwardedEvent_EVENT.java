package de.Dominik.SkyPvP.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class PlayerAchievementAwardedEvent_EVENT implements Listener{
	
	  @EventHandler
	  public void onAchievements(PlayerAchievementAwardedEvent e){
	    e.setCancelled(true);
	  }
	}