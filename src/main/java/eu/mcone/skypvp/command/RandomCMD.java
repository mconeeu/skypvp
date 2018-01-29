/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import java.util.Random;

import eu.mcone.bukkitcoresystem.CoreSystem;
import eu.mcone.skypvp.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class RandomCMD implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3){
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!CoreSystem.getInstance().getCooldownSystem().canExecute(this.getClass(), p)) return true;
            CoreSystem.getInstance().getCooldownSystem().addPlayer(p.getUniqueId(), this.getClass());

            if (p.hasPermission("skypvp.random")) {
                Integer Players = new Random().nextInt(Bukkit.getOnlinePlayers().size());
                Player randomplayer = (Player) Bukkit.getServer().getOnlinePlayers().toArray()[Players];

                Bukkit.broadcastMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§7Der Spieler §f" + randomplayer.getName() + " §7hat gewonnen!");
            }
        } else {
            sender.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + SkyPvP.config.getConfigValue("System-Konsolen-Sender"));
        }

        return true;
    }
}
