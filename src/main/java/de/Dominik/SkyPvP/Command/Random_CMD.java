package me.SkyPvP.Command.de;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.SkyPvP.Main.de.Main;


public class Random_CMD implements CommandExecutor{
	
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3){
    Player p = (Player)sender;
    if (((sender instanceof Player)) && 
      (cmd.getName().equalsIgnoreCase("random")) && (
      (p.hasPermission("skypvp.random")) || (p.hasPermission("skypvp.*") || p.hasPermission("system.*")))){
      Integer Players = Integer.valueOf(new Random().nextInt(Bukkit.getOnlinePlayers().size()));
      Player randomplayer = (Player)Bukkit.getServer().getOnlinePlayers().toArray()[Players.intValue()];
      
      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + "§7Der Spieler §f" + randomplayer.getName() + " §7hat gewonnen!");
    }
    return false;
  }
}
