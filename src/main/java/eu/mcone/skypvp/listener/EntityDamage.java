/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class EntityDamage implements Listener {

    @EventHandler
    public void on(EntityDamageEvent e){
        Entity ent = e.getEntity();

        if (ent instanceof Player) {
            Player p = (Player) ent;

            if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                e.setCancelled(true);
            } else if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                p.setHealth(1);
            }

            if (ent.getLocation().getY() > 100) {
                e.setCancelled(true);
                ent.setFireTicks(0);
            }
        }
    }

}
