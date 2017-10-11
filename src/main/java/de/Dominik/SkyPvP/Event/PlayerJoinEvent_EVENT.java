package de.Dominik.SkyPvP.Event;

import de.Dominik.SkyPvP.Command.SpawnManager_CMD;
import de.Dominik.SkyPvP.Listener.Scoreboard_LISTENER;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEvent_EVENT implements Listener{

	@EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();
    
        for (Player all : Bukkit.getOnlinePlayers()){
          	
	  	      Scoreboard_LISTENER.setScoreboard1(all);
	  	      
        }
        
        SpawnManager_CMD.teleportToSpawn(p);
       
       // e.setJoinMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " " + Main.cfg.getString("SkyPvP.Join").replaceAll("&", "§").replaceAll(">", "»").replaceAll("%Player%", p.getName()));
  	        
  	        // Vector v = p.getLocation().getDirection().multiply(2.0D).setY(1.0D);
  	        // p.setVelocity(v);
  	         p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 1.0F);
  	       p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10);
 }
}
