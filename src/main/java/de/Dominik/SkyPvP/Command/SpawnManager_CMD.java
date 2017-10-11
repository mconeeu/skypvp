package de.Dominik.SkyPvP.Command;


import java.io.File;

import de.Dominik.SkyPvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SpawnManager_CMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
    	if(!(sender instanceof Player)) {
			sender.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.Konsolen-Sender").replaceAll("&", "§").replaceAll(">", "»"));
			return true;
		}		
    	
        Player p;
        if (cmd.getName().equalsIgnoreCase("set")) {
            Player p2 = (Player)sender;
            if (p2.hasPermission("skypvp.setspawn") || p2.hasPermission("skypvp.*") || p2.hasPermission("system.*")) {
                double x = p2.getLocation().getX();
                double xf = Math.round(x);
                double y = p2.getLocation().getY();
                double yf = Math.round(y);
                File file = new File("plugins//McOne-SkyPvP//spawns.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
                p2.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " \u00a7bDie Spawnposition wurde zu: \u00a7cX, " + xf + " \u00a78| \u00a7cY, " + yf + "\u00a78 | \u00a7cZ, " + p2.getLocation().getY() + "\u00a7b ge\u00e4ndert! [Spawn]");
                cfg.set("Spawn.X", (Object)p2.getLocation().getX());
                cfg.set("Spawn.Y", (Object)p2.getLocation().getY());
                cfg.set("Spawn.Z", (Object)p2.getLocation().getZ());
                cfg.set("Spawn.Yaw", (Object)Float.valueOf(p2.getLocation().getYaw()));
                cfg.set("Spawn.Pitch", (Object)Float.valueOf(p2.getLocation().getPitch()));
                cfg.set("Spawn.WeltName", (Object)p2.getLocation().getWorld().getName());
                try {
                    cfg.save(file);
                }
                catch (Exception e1) {
                    Bukkit.broadcastMessage((String)"\u00a74\u00a7lFail to set the spawn in spawns.yml \u00a77[\u00a7SetArena-Class\u00a77]");
                }
            }
        }
		return false;
    }
    
    public static void teleportToSpawn(Player p) {
        File file = new File("plugins//McOne-SkyPvP//spawns.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        String w = cfg.getString("Spawn.WeltName");
        double x = cfg.getDouble("Spawn.X");
        double y = cfg.getDouble("Spawn.Y");
        double z = cfg.getDouble("Spawn.Z");
        double yaw = cfg.getDouble("Spawn.Yaw");
        double pitch = cfg.getDouble("Spawn.Pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        p.teleport(loc);
        if (!p.hasPlayedBefore()) {
            p.teleport(loc);
        }
        p.teleport(loc);
    }
}
