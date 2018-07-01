/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.Skypvp;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener{

	@EventHandler
    public void on(PlayerMoveEvent e) {
        Player p = e.getPlayer();

	    if (Skypvp.cooldownlist.contains(p)){
	    	Skypvp.cooldownlist.remove(p);
	        Skypvp.getInstance().getMessager().send(p, "§4Du hast dich bewegt! Teleportation abgebrochen");
	    }

    }
}
