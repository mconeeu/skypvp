/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.event;

import eu.mcone.skypvp.Main;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity_Event implements Listener {

    @EventHandler
    public void on(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity byEnt = e.getDamager();

        if (ent instanceof Player) {
            if (ent.getLocation().getY() > 100) {
                e.setCancelled(true);
                byEnt.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du darfst am Spawn nicht kämpfen!");
            } else {
                ent.getWorld().playEffect(ent.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
            }
        } else if (ent instanceof Villager){
            e.setCancelled(true);

            if (byEnt instanceof Projectile) {
                Projectile x = (Projectile) e.getDamager();
                if (x.getType() == EntityType.FISHING_HOOK) {
                    e.setCancelled(true);
                }
            }
        } else if ((ent instanceof ItemFrame) && (byEnt instanceof Player)) {
            Player p = (Player) byEnt;
            if (p.getGameMode() == GameMode.CREATIVE) {
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
            }
        } else if ((ent instanceof ItemFrame) && (byEnt instanceof Projectile)) {
            Projectile x = (Projectile) e.getDamager();
            if (x.getType() == EntityType.FISHING_HOOK) {
                e.setCancelled(true);
            }
        } else if ((ent instanceof ItemFrame) && (byEnt != null)) {
            Projectile x = (Projectile) e.getDamager();
            if (x.getType() == EntityType.ARROW) {
                e.setCancelled(true);
            }
        }
    }

}
