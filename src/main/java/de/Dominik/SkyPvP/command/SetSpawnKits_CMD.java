
package de.Dominik.SkyPvP.command;

import de.Dominik.SkyPvP.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public  class SetSpawnKits_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			Player p = (Player)sender;
			if(sender == null) {
				Bukkit.getConsoleSender().sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
				return true;
			}

			if(p.hasPermission("skypvp.setkits") || p.hasPermission("skypvp.*") || p.hasPermission("system.*")) {
				Villager i = (Villager) p.getWorld().spawnCreature(p.getLocation(), EntityType.VILLAGER);
				i.setCustomName("§9SkyPvP §8» §cKits");
				i.setCustomNameVisible(true);
			}else{
				p.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-No-Perm"));
			}
	
		return false;
	}

}
