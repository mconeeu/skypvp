package de.Dominik.SkyPvP.command;

import de.Dominik.BukkitCoreSystem.util.ItemManager;
import de.Dominik.SkyPvP.Main;
import de.Dominik.SkyPvP.inventory.KitInventory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;


public class Kit_CMD implements CommandExecutor {
private Plugin plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;

		if(sender == null) {
			Bukkit.getConsoleSender().sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
			return true;
		} else if (cmd.getName().equalsIgnoreCase("kit") || cmd.getName().equalsIgnoreCase("kits")) {
		    if (args.length == 0){
				new KitInventory(p);
				p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
		    } else {
		        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§cBitte nutze den Command /kit");
		    }

		    return false;
        }

		return false;
	}
}