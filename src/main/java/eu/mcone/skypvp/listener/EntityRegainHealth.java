/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.SkyPvP;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class EntityRegainHealth implements Listener {

    @EventHandler
    public void on(EntityRegainHealthEvent e) {
        if (e.getEntityType().equals(EntityType.PLAYER)) {
            Player p = (Player) e.getEntity();

            if (p.getHealth() >= p.getMaxHealth()) {
                SkyPvP.damager.put(p, null);
            }
        }
    }

}
