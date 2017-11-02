package de.Dominik.SkyPvP.command;

import de.Dominik.SkyPvP.Main;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed_CMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args){
	    Player p = (Player)sender;
	    if(sender == null) {
			sender.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
			return true;
		} else if (cmd.getName().equalsIgnoreCase("Feed")){
	    	if(p.hasPermission("skypvp.feed") || p.hasPermission("skypvp.*") || p.hasPermission("system.*")){
	         p.setFoodLevel(20);
	   	      p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 5);
	   	      p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du hast nun wieder Volles §bEssen !");
	   	      p.setFireTicks(1);	
	    	}else{
	    		p.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-No-Perm"));
	    	}
	    }
		return false;
	 }
}
