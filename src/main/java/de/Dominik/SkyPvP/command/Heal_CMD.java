package de.Dominik.SkyPvP.command;

import de.Dominik.SkyPvP.Main;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal_CMD implements CommandExecutor{
	  
	 public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args){
	    Player p = (Player)sender;
	    if(!(sender instanceof Player)) {
			sender.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
			return true;
		}	
	    if (cmd.getName().equalsIgnoreCase("Heal")){
	    	if(p.hasPermission("skypvp.heal") || p.hasPermission("skypvp.*") || p.hasPermission("system.*")){
	          p.setHealth(20.0D);
	   	      p.setFoodLevel(20);
	   	      p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 5);
	   	      p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du hast nun wieder Volles §bLeben !");
	   	      p.setFireTicks(1);	
	    	}
	    }else{
	    	p.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-No-Perm"));
	    }
		return false;
	 }
}
