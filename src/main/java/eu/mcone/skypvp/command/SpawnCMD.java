/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.util.Messager;
import eu.mcone.skypvp.SkyPvP;
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
                SkyPvP.getInstance().getMessager().send(p, "§7Du wirst in §c3 §7Sekunden Teleportiert... §4Bewege dich nicht!");
                SkyPvP.cooldownlist.add(p);

                Bukkit.getScheduler().runTaskLaterAsynchronously(SkyPvP.getInstance(), () -> {
                    if (SkyPvP.cooldownlist.contains(p)) {
                        SkyPvP.getInstance().getLocationManager().teleport(p, "spawn");
                        SkyPvP.cooldownlist.remove(p);
                    }
                }, 60L);
            } else if (args[0].equals("set")) {
                if (p.hasPermission("skypvp.spawn.set")) {
                    if (args.length == 1) {
                        if (p.hasPermission("group.admin") || p.hasPermission("group.developer")) {
                            SkyPvP.getInstance().getLocationManager().putLocation("spawn", p.getLocation());
                            SkyPvP.getInstance().getMessager().send(p, "§2Der Spawn wurde erfolgreich gesetzt!");
                        } else {
                            SkyPvP.getInstance().getMessager().send(p, "§4Du hast keine Berechtigung für diesen Befehl!");
                        }
                    }
                }
            }
        } else {
            SkyPvP.getInstance().getMessager().sendTransl(sender, "system.command.consolesender");
        }

        return true;
    }
}
