package de.Dominik.SkyPvP.command;

import de.Dominik.BukkitCoreSystem.util.LocationFactory;
import de.Dominik.SkyPvP.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn_CMD implements CommandExecutor{
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        final Player p = (Player)sender;

        if (args.length == 0) {
            if(sender == null) {
                Bukkit.getConsoleSender().sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
                return true;
            }

            Main.cooldownlist.add(p);
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du wirst in §c5 §7Sekunden Teleportiert... §4Bewege dich nicht!");

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                if (Main.cooldownlist.contains(p)){
                    Location spawn = LocationFactory.getConfigLocation(Main.config, "Location-Spawn");

                    if (spawn != null) {
                        p.teleport(spawn);
                    } else {
                        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du konntest nicht zum Spawn teleportiert werden, da der Spawn noch nicht gesetzt wurde!");
                    }

                    Main.cooldownlist.remove(p);
                }
            }, 100L);
        } else if ((args.length == 1) && (args[0].equals("set"))) {
            if (p.hasPermission("group.admin") || p.hasPermission("group.developer")) {
                LocationFactory.updateConfigLocation(p.getLocation(), Main.config, "Location-Spawn");
                p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§2Der Spawn wurde erfolgreich gesetzt!");
            } else {
                p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du hast keine Berechtigung für diesen Befehl!");
            }
        }

        return true;
    }
}
