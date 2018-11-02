/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.skypvp.Skypvp;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SpawnCMD extends CorePlayerCommand {

    public SpawnCMD() {
        super("spawn");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        Skypvp.getInstance().getMessager().send(p, "§7Du wirst in §c3 §7Sekunden Teleportiert... §4Bewege dich nicht!");
        Skypvp.cooldownlist.add(p);

        Bukkit.getScheduler().runTaskLaterAsynchronously(Skypvp.getInstance(), () -> {
            if (Skypvp.cooldownlist.contains(p)) {
                Skypvp.getInstance().getWorld().teleport(p, "spawn");
                Skypvp.cooldownlist.remove(p);
            }
        }, 60L);
        return true;
    }
}
