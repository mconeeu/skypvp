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
        Location loc = p.getLocation();

        /*
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        Location loc1 = new Location(p.getLocation().getWorld(), x, y, z);

        if (loc1.subtract(0.0, 0.5, 0.0).getBlock().getType().equals(Material.SPONGE)) {
            Vector v = p.getLocation().getDirection().multiply(1.5).setY(1.2);
            p.setVelocity(v);
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 3.0f, 2.0f);
            p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 2);
        }
        */

	    if (Main.cooldownlist.contains(p)){
	    	Main.cooldownlist.remove(p);
	        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du hast dich bewegt! Teleportation abgebrochen");
	    }

    }
}
