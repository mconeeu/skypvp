/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.inventory.KitInventory;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!CoreSystem.getInstance().getCooldownSystem().addAndCheck(CoreSystem.getInstance(), this.getClass(), p.getUniqueId())) return false;

			if (args.length == 0) {
				new KitInventory(p);
				p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
			} else {
				Skypvp.getInstance().getMessager().send(p, "§cBitte nutze den Command /kit");
			}
		} else {
			Skypvp.getInstance().getMessager().sendTransl(sender, "system.command.consolesender");
		}

		return true;
	}
}