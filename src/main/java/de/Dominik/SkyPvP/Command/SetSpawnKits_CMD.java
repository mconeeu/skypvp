
package de.Dominik.SkyPvP.Command;

import de.Dominik.SkyPvP.Main.Main;
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
			if(!(sender instanceof Player)) {
				sender.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.Konsolen-Sender").replaceAll("&", "§").replaceAll(">", "»"));
				return true;
			}	
			if(p.hasPermission("skypvp.setkits") || p.hasPermission("skypvp.*") || p.hasPermission("system.*")) {
				Villager i = (Villager) p.getWorld().spawnCreature(p.getLocation(), EntityType.VILLAGER);
				i.setCustomName("§9SkyPvP §8» §cKits");
				i.setCustomNameVisible(true);
			}else{
				p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.No-Perm").replaceAll("&", "§").replaceAll(">", "»"));
			}
	
		return false;
	}

}
