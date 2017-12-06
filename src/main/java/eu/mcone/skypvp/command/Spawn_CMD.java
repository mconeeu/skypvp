/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.bukkitcoresystem.util.LocationFactory;
import eu.mcone.skypvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class Spawn_CMD implements CommandExecutor{
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
            return true;
        }
        final Player p = (Player)sender;

        if (args.length == 0) {
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du wirst in §c3 §7Sekunden Teleportiert... §4Bewege dich nicht!");
            Main.cooldownlist.add(p);

            Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), () -> {
                if (Main.cooldownlist.contains(p)){
                    Location spawn = LocationFactory.getConfigLocation(Main.config, "Location-Spawn");

                    if (spawn != null) {
                        p.teleport(spawn);
                    } else {
                        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du konntest nicht zum Spawn teleportiert werden, da der Spawn noch nicht gesetzt wurde!");
                    }

                    Main.cooldownlist.remove(p);
                }
            }, 60L);
        } else if (args[0].equals("set")) {
            if (p.hasPermission("skypvp.spawn.set")) {
                if (args.length == 1) {
                    if (p.hasPermission("group.admin") || p.hasPermission("group.developer")) {
                        LocationFactory.updateConfigLocation(p.getLocation(), Main.config, "Location-Spawn");
                        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§2Der Spawn wurde erfolgreich gesetzt!");
                    } else {
                        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du hast keine Berechtigung für diesen Befehl!");
                    }
                } else if (args.length == 2) {
                    if (args[1].equals("spawnkits")) {
                        Villager i = (Villager) p.getWorld().spawnCreature(p.getLocation(), EntityType.VILLAGER);
                        i.setCustomName("§9SkyPvP §8» §cKits");
                        i.setCustomNameVisible(true);
                    } else if (args[1].equals("spawnshop")) {
                        Villager v = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                        v.setCustomName("§9SkyPvP §8» §cShop");
                        v.setCustomNameVisible(true);
                        v.setCanPickupItems(false);
                        v.setNoDamageTicks(0);
                        v.damage(0.0D);
                        v.setFireTicks(0);
                    }
                }
            }
        }

        return true;
    }
}
