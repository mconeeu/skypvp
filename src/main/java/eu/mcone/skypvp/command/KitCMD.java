/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.skypvp.Skypvp;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class KitCMD extends CorePlayerCommand {

	public KitCMD() {
		super("kit", null, "k");
	}

	@Override
	public boolean onPlayerCommand(Player p, String[] args) {
		if (args.length == 0) {
			Skypvp.getInstance().getKitManager().openKitsInventory(p,p::closeInventory);
			p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
		} else {
			Skypvp.getInstance().getMessenger().send(p, "§cBitte nutze den Command /kit");
		}
		return true;
	}

}