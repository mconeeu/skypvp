package de.Dominik.SkyPvP.Command;

import de.Dominik.SkyPvP.Command.SpawnManager_CMD;
import de.Dominik.SkyPvP.Listener.Listener_LISTENER;
import de.Dominik.SkyPvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn_CMD implements CommandExecutor{
	
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
  final Player p = (Player)sender;
  if(!(sender instanceof Player)) {
		sender.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.Konsolen-Sender").replaceAll("&", "§").replaceAll(">", "»"));
		return true;
	}	
 Listener_LISTENER.cooldownlist.add(p);
  p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §7Du wirst in §c5 §7Sekunden Teleportiert  §4Beweg dich nicht");
  
  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.main, new Runnable(){
      public void run(){
    	  if (Listener_LISTENER.cooldownlist.contains(p)){
        	  SpawnManager_CMD.teleportToSpawn(p);
            Listener_LISTENER.cooldownlist.remove(p);
          }
    	  
      }
    }, 100L);
  
  return true;
  }
}
