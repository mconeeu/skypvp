/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import java.util.Random;

import eu.mcone.skypvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Random_CMD implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3){
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
            return true;
        }

        Player p = (Player)sender;
        if (p.hasPermission("skypvp.random")){
            Integer Players = new Random().nextInt(Bukkit.getOnlinePlayers().size());
            Player randomplayer = (Player)Bukkit.getServer().getOnlinePlayers().toArray()[Players];

            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§7Der Spieler §f" + randomplayer.getName() + " §7hat gewonnen!");
        }

        return true;
    }
}
