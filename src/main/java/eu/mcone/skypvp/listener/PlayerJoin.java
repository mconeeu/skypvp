/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.BukkitCorePlayer;
import eu.mcone.skypvp.SkyPvP;
import eu.mcone.skypvp.kit.Kit;
import eu.mcone.skypvp.util.Objective;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener{

	@EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        BukkitCorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        p.setLevel(0);
        SkyPvP.getInstance().getLocationManager().teleport(p, "spawn");
       
        e.setJoinMessage(SkyPvP.config.getConfigValue("System-Prefix") + SkyPvP.config.getConfigValue("System-Join").replaceAll("%Player%", p.getName()));

        cp.getScoreboard().setNewObjective(new Objective());

        if (hasEmptyInventory(p)) {
            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§7Du scheinst neu auf SkyPvP zu sein! Du bekommst das Standart-Kit!");
            SkyPvP.getInstance().getKitManager().setKit(p, Kit.PLAYER);
        }

        p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10);
    }

    private boolean hasEmptyInventory(Player p) {
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null) {
                return false;
            }
        }
        return true;
    }
}
