/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.bukkitcoresystem.CoreSystem;
import eu.mcone.skypvp.Main;
import eu.mcone.skypvp.inventory.KitInventory;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class Kit_CMD implements CommandExecutor {
private Plugin plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!CoreSystem.cooldown.canExecute(this.getClass(), p)) return true;
			CoreSystem.cooldown.addPlayer(p.getUniqueId(), this.getClass());

			if (args.length == 0) {
				KitInventory.open(p);
				p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
			} else {
				p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§cBitte nutze den Command /kit");
			}
		} else {
			sender.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
		}

		return true;
	}
}