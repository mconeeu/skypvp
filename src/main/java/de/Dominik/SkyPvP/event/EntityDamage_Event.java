/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage_Event implements Listener {

    @EventHandler
    public void on(EntityDamageEvent event){
        try{
            if (!(event.getEntity() instanceof Player)) {
                return;
            }
            if ((event.getCause().equals(EntityDamageEvent.DamageCause.FALL))){
                event.setCancelled(true);
            }

        }catch(NullPointerException e1){
            e1.printStackTrace();
        }
    }

}
