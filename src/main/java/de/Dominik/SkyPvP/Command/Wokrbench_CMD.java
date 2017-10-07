package me.SkyPvP.Command.de;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.SkyPvP.Main.de.Main;

public class Wokrbench_CMD implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "§") + Main.cfg.getString("SkyPvP.Konsolen-Sender").replaceAll("&", "§").replaceAll(">", "§"));
			return true;
		}	
		
		Player p = (Player) sender;
		 if (cmd.getName().equalsIgnoreCase("wb")){
		    	if(p.hasPermission("SkyPvP.wb") || p.hasPermission("SkyPvP.*") || p.hasPermission("System.*")){
		    		p.openWorkbench(null, true);
		    		p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 1.0F);
		    	}else{
		    		p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "§") + Main.cfg.getString("SkyPvP.No-Perm").replaceAll("&", "§").replaceAll(">", "§"));
		    	}
		    }
		return false;
	}
}
