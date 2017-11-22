/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.command;

import de.Dominik.SkyPvP.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Endechest_CMD implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
			return true;
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ec")){
			p.openInventory(p.getEnderChest());
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
		}
		return false;
	}
}
