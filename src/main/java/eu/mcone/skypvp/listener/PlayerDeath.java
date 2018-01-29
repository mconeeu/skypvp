/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.bukkitcoresystem.api.CoinsAPI;
import eu.mcone.gameapi.GameAPI;
import eu.mcone.skypvp.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.text.DecimalFormat;

import static eu.mcone.bukkitcoresystem.CoreSystem.statsSkypvp;

public class PlayerDeath implements Listener {

    @EventHandler
    public void on(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = p.getKiller() != null ? p.getKiller() : GameAPI.getInstance().getDamageLogger().getKiller(p);

        e.setDeathMessage(null);
        e.setKeepInventory(false);
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
            k.setLevel(i+1);

            for (int streak : new int[]{3,5,10,15,20,25,30,35,40,50,55,60}) {
                if (p.getLevel() == streak) {
                    Bukkit.broadcastMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§f" + p.getName() + " §6hat eine §c"+streak+"er §6Killstreak!");
                }
            }

            //Coins werden dem Killer Hinzugefügt
            CoinsAPI.addCoins(k.getUniqueId(), 5);

            //Kills werden dem Killer Hinzugefügt (1)
            statsSkypvp.addKills(k.getUniqueId(), 1);

            DecimalFormat format = new DecimalFormat("#.#");
            double health = k.getHealth();
            health /= 2.0D;

            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§7Du wurdest von §6" + k.getDisplayName() + " §8[§c❤"+format.format(health)+"§8] §7getötet §8[§c-2 Coins§8]");
            k.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§7Du hast §6" + p.getDisplayName() + " §7getötet §8[§a+5 Coins§8]");

        } else {
            int coins = CoinsAPI.getCoins(p.getUniqueId());
            if(coins >= 3){
                //Coins werden dem Spieler Abgezogen (3)
                CoinsAPI.removeCoins(p.getUniqueId(), 3);
            }
            //Tod wird dem Spieler hinzugefügt
            statsSkypvp.addDeaths(p.getUniqueId(), 1);

            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§7Du bist gestorben §8[§c-3 Coins§8]");
        }
    }

}
