package de.Dominik.SkyPvP.event;

import de.Dominik.BukkitCoreSystem.util.LocationFactory;
import de.Dominik.SkyPvP.Main;
import de.Dominik.SkyPvP.util.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin_Event implements Listener{

	@EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();
    
        for (Player all : Bukkit.getOnlinePlayers()){
	  	      ScoreboardManager.setScoreboard(all);
        }

        Location spawn = LocationFactory.getConfigLocation(Main.config, "Location-Spawn");

        if (spawn != null) {
            p.teleport(spawn);
        } else if(p.hasPermission("group.admin")) {
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Der Spawn wurde noch nicht gesetzt!");
        }
       
       // e.setJoinMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Join").replaceAll("%Player%", p.getName()));
  	        
  	        // Vector v = p.getLocation().getDirection().multiply(2.0D).setY(1.0D);
  	        // p.setVelocity(v);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 1.0F);
        p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10);
    }
}
