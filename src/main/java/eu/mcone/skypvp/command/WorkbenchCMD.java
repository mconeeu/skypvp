/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.skypvp.SkyPvP;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorkbenchCMD implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!CoreSystem.getInstance().getCooldownSystem().canExecute(this.getClass(), p)) return true;
			CoreSystem.getInstance().getCooldownSystem().addPlayer(p.getUniqueId(), this.getClass());

			p.openWorkbench(null, true);
			p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
		} else {
			sender.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + SkyPvP.config.getConfigValue("System-Konsolen-Sender"));
		}
		return true;
	}
}
