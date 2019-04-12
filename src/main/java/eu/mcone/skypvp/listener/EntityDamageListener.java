/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.Skypvp;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e){
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

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity byEnt = e.getDamager();

        if (byEnt instanceof Player && !((Player) byEnt).getGameMode().equals(GameMode.CREATIVE)) {
            if (ent instanceof Player) {
                if (ent.getLocation().getY() > 100) {
                    e.setCancelled(true);
                    Skypvp.getInstance().getMessager().send(byEnt, "§4Du darfst am Spawn nicht kämpfen!");
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
