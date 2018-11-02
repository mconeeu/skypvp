/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.player.SkypvpPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void on(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        p.setLevel(0);
        e.setQuitMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + CoreSystem.getInstance().getTranslationManager().get("skypvp.quit").replaceAll("%player%", p.getName()));

        SkypvpPlayer sp = Skypvp.getInstance().getSkypvpPlayer(p.getUniqueId());

        sp.saveData();
        Skypvp.getInstance().unregisterSkypvpPlayer(sp);
    }

}
