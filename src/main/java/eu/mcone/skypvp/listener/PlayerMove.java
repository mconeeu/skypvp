/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.skypvp.SkyPvP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener{

	@EventHandler
    public void on(PlayerMoveEvent e) {
        Player p = e.getPlayer();

	    if (SkyPvP.cooldownlist.contains(p)){
	    	SkyPvP.cooldownlist.remove(p);
	        p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§4Du hast dich bewegt! Teleportation abgebrochen");
	    }

    }
}
