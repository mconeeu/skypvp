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

public class EntityDamage implements Listener {

    @EventHandler
    public void on(EntityDamageEvent e){
        Entity entity = e.getEntity();

        if (entity instanceof Player) {
            e.setCancelled(e.getCause().equals(EntityDamageEvent.DamageCause.FALL));
        }
    }

}
