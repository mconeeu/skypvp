/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.player.Kit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener{

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        final Player p = e.getPlayer();

        e.setRespawnLocation(Skypvp.getInstance().getWorld().getLocation("spawn").bukkit(Skypvp.getInstance().getWorld()));

        p.setFireTicks(0);

        Bukkit.getScheduler().scheduleSyncDelayedTask(Skypvp.getInstance(), () -> {
            p.getInventory().clear();
            Skypvp.getInstance().getKitManager().setKit(Skypvp.getInstance().getSkypvpPlayer(p.getUniqueId()), Kit.PLAYER);
        });
    }

}
