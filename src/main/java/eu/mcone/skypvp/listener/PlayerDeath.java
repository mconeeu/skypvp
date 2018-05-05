/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.core.gamemode.Gamemode;
import eu.mcone.gameapi.api.GameAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.text.DecimalFormat;

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
            int coins = CoreSystem.getInstance().getCoinsAPI().getCoins(p.getUniqueId());
            if(coins >= 1){
                //Coins werden dem Spieler Abgezogen
                CoreSystem.getInstance().getCoinsAPI().removeCoins(p.getUniqueId(), 1);
            }

            //Tode werden dem Spieler Hinzugefügt
            CoreSystem.getInstance().getStatsAPI(Gamemode.SKYPVP).addDeaths(p.getUniqueId(), 1);

            int i = k.getLevel();
            k.setLevel(i+1);

            for (int streak : new int[]{3,5,10,15,20,25,30,35,40,50,55,60}) {
                if (p.getLevel() == streak) {
                    Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§f" + p.getName() + " §6hat eine §c"+streak+"er §6Killstreak!");
                    break;
                }
            }

            //Coins werden dem Killer Hinzugefügt
            CoreSystem.getInstance().getCoinsAPI().addCoins(k.getUniqueId(), 3);

            //Kills werden dem Killer Hinzugefügt (1)
            CoreSystem.getInstance().getStatsAPI(Gamemode.SKYPVP).addKills(k.getUniqueId(), 1);

            DecimalFormat format = new DecimalFormat("#.#");
            double health = k.getHealth();
            health /= 2.0D;

            p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§7Du wurdest von §6" + k.getDisplayName() + " §8[§c❤"+format.format(health)+"§8] §7getötet §8[§c-1 Coins§8]");
            k.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§7Du hast §6" + p.getDisplayName() + " §7getötet §8[§a+3 Coins§8]");

        } else {
            int coins = CoreSystem.getInstance().getCoinsAPI().getCoins(p.getUniqueId());
            if(coins >= 3){
                //Coins werden dem Spieler Abgezogen (3)
                CoreSystem.getInstance().getCoinsAPI().removeCoins(p.getUniqueId(), 3);
            }
            //Tod wird dem Spieler hinzugefügt
            CoreSystem.getInstance().getStatsAPI(Gamemode.SKYPVP).addDeaths(p.getUniqueId(), 1);

            p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§7Du bist gestorben §8[§c-3 Coins§8]");
        }
    }

}
