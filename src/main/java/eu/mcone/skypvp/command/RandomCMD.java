/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CoreCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomCMD extends CoreCommand {

    public RandomCMD() {
        super("random", "skypvp.random");
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        Integer Players = new Random().nextInt(Bukkit.getOnlinePlayers().size());
        Player randomplayer = (Player) Bukkit.getServer().getOnlinePlayers().toArray()[Players];

        Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§7Der Spieler §f" + randomplayer.getName() + " §7hat gewonnen!");
        return true;
    }
}
