package me.SkyPvP.Command.de;

import java.util.HashMap;

import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.SkyPvP.Main.de.Main;

public class Feed_CMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args){
	    Player p = (Player)sender;
	    if(!(sender instanceof Player)) {
			sender.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.Konsolen-Sender").replaceAll("&", "§").replaceAll(">", "»"));
			return true;
		}	
	    if (cmd.getName().equalsIgnoreCase("Feed")){
	    	if(p.hasPermission("skypvp.feed") || p.hasPermission("skypvp.*") || p.hasPermission("system.*")){
	         p.setFoodLevel(20);
	   	      p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 5);
	   	      p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §7Du hast nun wieder Volles §bEssen !");
	   	      p.setFireTicks(1);	
	    	}else{
	    		p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.No-Perm").replaceAll("&", "§").replaceAll(">", "»"));
	    	}
	    }
		return false;
	 }
}
