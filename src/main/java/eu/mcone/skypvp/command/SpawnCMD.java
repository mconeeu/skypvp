/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.skypvp.Skypvp;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor{
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player) {
            final Player p = (Player) sender;
            if (!CoreSystem.getInstance().getCooldownSystem().addAndCheck(CoreSystem.getInstance(), this.getClass(), p.getUniqueId())) return false;

            if (args.length == 0) {
                Skypvp.getInstance().getMessager().send(p, "§7Du wirst in §c3 §7Sekunden Teleportiert... §4Bewege dich nicht!");
                Skypvp.cooldownlist.add(p);

                Bukkit.getScheduler().runTaskLaterAsynchronously(Skypvp.getInstance(), () -> {
                    if (Skypvp.cooldownlist.contains(p)) {
                        Skypvp.getInstance().getWorld().teleport(p, "spawn");
                        Skypvp.cooldownlist.remove(p);
                    }
                }, 60L);
            }
        } else {
            Skypvp.getInstance().getMessager().sendTransl(sender, "system.command.consolesender");
        }

        return true;
    }
}
