/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class WorkbenchCMD extends CorePlayerCommand {

	public WorkbenchCMD() {
		super("workbench", null, "wb");
	}

	@Override
	public boolean onPlayerCommand(Player p, String[] args) {
		p.openWorkbench(null, true);
		p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);

		return true;
	}
}
