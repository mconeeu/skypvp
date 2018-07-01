/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener{

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        Skypvp.damager.put(p, null);

        e.setRespawnLocation(Skypvp.getInstance().getWorld().getLocation("spawn").bukkit());

        p.setFireTicks(0);

        Bukkit.getScheduler().scheduleSyncDelayedTask(Skypvp.getInstance(), () -> {
            p.getInventory().clear();
            Skypvp.getInstance().getKitManager().resetKits(p);
            Skypvp.getInstance().getKitManager().setKit(p, Kit.PLAYER);
        });
    }

}
