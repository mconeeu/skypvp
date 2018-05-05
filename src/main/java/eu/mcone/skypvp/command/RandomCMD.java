/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.util.Messager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomCMD implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3){
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!CoreSystem.getInstance().getCooldownSystem().addAndCheck(CoreSystem.getInstance(), this.getClass(), p.getUniqueId())) return false;

            if (p.hasPermission("skypvp.random")) {
                Integer Players = new Random().nextInt(Bukkit.getOnlinePlayers().size());
                Player randomplayer = (Player) Bukkit.getServer().getOnlinePlayers().toArray()[Players];

                Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§7Der Spieler §f" + randomplayer.getName() + " §7hat gewonnen!");
            }
        } else {
            Messager.sendTransl(sender, "system.command.consolesender");
        }

        return true;
    }
}
