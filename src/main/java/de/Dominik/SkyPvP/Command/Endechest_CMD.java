package de.Dominik.SkyPvP.Command;

import de.Dominik.SkyPvP.Main.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Endechest_CMD implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.Konsolen-Sender").replaceAll("&", "§").replaceAll(">", "»"));
			return true;
		}	
		Player p = (Player) sender;
		 if (cmd.getName().equalsIgnoreCase("ec")){
		    	if(p.hasPermission("skypvp.ec") || p.hasPermission("skypvp.*") || p.hasPermission("system.*")){
		    		p.openInventory(p.getEnderChest());
		    		p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 1.0F);
		    	}else{
		    		p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.No-Perm").replaceAll("&", "§").replaceAll(">", "»"));
		    	}
		    }
		return false;
	}
}
