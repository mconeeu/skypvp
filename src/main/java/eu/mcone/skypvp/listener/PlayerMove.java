/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.Main;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerMove implements Listener{

	@EventHandler
    public void on(PlayerMoveEvent e) {
        Player p = e.getPlayer();

	    if (Main.cooldownlist.contains(p)){
	    	Main.cooldownlist.remove(p);
	        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du hast dich bewegt! Teleportation abgebrochen");
	    }

    }
}
