/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.bukkitcoresystem.api.CoinsAPI;
import eu.mcone.skypvp.Main;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.text.DecimalFormat;
import java.util.HashMap;

import static eu.mcone.bukkitcoresystem.CoreSystem.statsSkypvp;

public class PlayerDeath implements Listener {

    @EventHandler
    public void on(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = p.getKiller() != null ? p.getKiller() : Main.damager.getOrDefault(p, null);

        e.setDeathMessage(null);
        e.getDrops().clear();
        p.setLevel(0);
        p.spigot().respawn();
        p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1.0F, 1.0F);

        if(k != null){
            int coins = CoinsAPI.getCoins(p.getUniqueId());
            if(coins >= 2){
                //Coins werden dem Spieler Abgezogen
                CoinsAPI.removeCoins(p.getUniqueId(), 2);
            }

            //Tode werden dem Spieler Hinzugefügt
            statsSkypvp.addDeaths(p.getUniqueId(), 1);

            int i = k.getLevel();
            i++;
            k.setLevel(i);
            checkLevel(i, k);

            //Coins werden dem Killer Hinzugefügt
            CoinsAPI.addCoins(k.getUniqueId(), 5);

            //Kills werden dem Killer Hinzugefügt (1)
            statsSkypvp.addKills(k.getUniqueId(), 1);

            DecimalFormat format = new DecimalFormat("#.#");
            double health = k.getHealth() / k.getMaxHealth() * k.getHealthScale();
            health /= 2.0D;

            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du wurdest von §6" + k.getDisplayName() + " §8[§c❤"+format.format(health)+"§8] §7getötet §8[§c-2 Coins§8]");
            k.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du hast §6" + p.getDisplayName() + " §7getötet §8[§a+5 Coins§8]");

        } else {
            int coins = CoinsAPI.getCoins(p.getUniqueId());
            if(coins >= 3){
                //Coins werden dem Spieler Abgezogen (3)
                CoinsAPI.removeCoins(p.getUniqueId(), 3);
            }
            //Tod wird dem Spieler hinzugefügt
            statsSkypvp.addDeaths(p.getUniqueId(), 1);

            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du bist gestorben §8[§c-3 Coins§8]");
        }
    }

    private void checkLevel(int i, Player p){

        if (i == 3) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c3er §6Killstreak!");
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§2Du hast §a10 Coins§2 erhalten!");
            //Coins werden dem Spieler Hinzugefügt (10)
            CoinsAPI.addCoins(p.getUniqueId(), 10);

        }

        if (i == 5) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c5er §6Killstreak!");
        }
        if (i == 10) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c10er §6Killstreak!");
        }
        if (i == 15) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c15er §6Killstreak!");
        }
        if (i == 20) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c20er §6Killstreak!");
        }
        if (i == 25) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c25er §6Killstreak!");
        }
        if (i == 30) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c30er §6Killstreak!");
        }
        if (i == 35) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c35er §6Killstreak!");
        }
        if (i == 40) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c40er §6Killstreak!");
        }
        if (i == 45) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c45er §6Killstreak!");
        }
        if (i == 50) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c50er §6Killstreak!");
        }
        if (i == 55) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c55er §6Killstreak!");
        }
        if (i == 60) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c60er §6Killstreak!");
        }
    }

}
