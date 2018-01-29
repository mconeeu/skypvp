/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.SkyPvP;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {

    @EventHandler
    public void on(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity byEnt = e.getDamager();

        if (byEnt instanceof Player && !((Player) byEnt).getGameMode().equals(GameMode.CREATIVE)) {
            if (ent instanceof Player) {
                if (ent.getLocation().getY() > 100) {
                    e.setCancelled(true);
                    byEnt.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du darfst am Spawn nicht kämpfen!");
                } else {
                    ent.getWorld().playEffect(ent.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
                }
            } else if (ent instanceof Villager) {
                e.setCancelled(true);

                if (byEnt instanceof Projectile) {
                    Projectile x = (Projectile) e.getDamager();
                    if (x.getType() == EntityType.FISHING_HOOK) {
                        e.setCancelled(true);
                    }
                }
            } else if (ent instanceof ItemFrame) {
                e.setCancelled(true);
            }
        }
    }

}
