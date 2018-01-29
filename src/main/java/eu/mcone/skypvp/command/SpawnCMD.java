/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.bukkitcoresystem.CoreSystem;
import eu.mcone.bukkitcoresystem.util.LocationFactory;
import eu.mcone.skypvp.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor{
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player) {
            final Player p = (Player) sender;
            if (!CoreSystem.getInstance().getCooldownSystem().canExecute(this.getClass(), p)) return true;
            CoreSystem.getInstance().getCooldownSystem().addPlayer(p.getUniqueId(), this.getClass());

            if (args.length == 0) {
                p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§7Du wirst in §c3 §7Sekunden Teleportiert... §4Bewege dich nicht!");
                SkyPvP.cooldownlist.add(p);

                Bukkit.getScheduler().runTaskLaterAsynchronously(SkyPvP.getInstance(), () -> {
                    if (SkyPvP.cooldownlist.contains(p)) {
                        Location spawn = LocationFactory.getConfigLocation(SkyPvP.config, "Location-Spawn");

                        if (spawn != null) {
                            p.teleport(spawn);
                        } else {
                            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du konntest nicht zum Spawn teleportiert werden, da der Spawn noch nicht gesetzt wurde!");
                        }

                        SkyPvP.cooldownlist.remove(p);
                    }
                }, 60L);
            } else if (args[0].equals("set")) {
                if (p.hasPermission("skypvp.spawn.set")) {
                    if (args.length == 1) {
                        if (p.hasPermission("group.admin") || p.hasPermission("group.developer")) {
                            LocationFactory.updateConfigLocation(p.getLocation(), SkyPvP.config, "Location-Spawn");
                            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§2Der Spawn wurde erfolgreich gesetzt!");
                        } else {
                            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du hast keine Berechtigung für diesen Befehl!");
                        }
                    }
                }
            }
        } else {
            sender.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + SkyPvP.config.getConfigValue("System-Konsolen-Sender"));
        }

        return true;
    }
}
