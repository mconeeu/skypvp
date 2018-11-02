/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.core.gamemode.Gamemode;
import eu.mcone.gamesystem.api.GameSystemAPI;
import eu.mcone.skypvp.Skypvp;
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
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        Player k = p.getKiller() != null ? p.getKiller() : GameSystemAPI.getInstance().getDamageLogger().getKiller(p);

        e.setDeathMessage(null);
        e.setKeepInventory(false);
        e.getDrops().clear();
        p.setLevel(0);
        p.spigot().respawn();
        p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1.0F, 1.0F);

        if(k != null){
            CorePlayer ck = CoreSystem.getInstance().getCorePlayer(k);

            ck.addCoins(3);
            ck.getStats(Gamemode.SKYPVP).addKills(1);

            cp.getStats(Gamemode.SKYPVP).addDeaths(1);
            if(cp.getCoins() > 0) cp.removeCoins(1);
            k.setLevel(k.getLevel()+1);

            for (int streak : new int[]{3,5,10,15,20,25,30,35,40,50,55,60}) {
                if (p.getLevel() == streak) {
                    Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§f" + p.getName() + " §6hat eine §c"+streak+"er §6Killstreak!");
                    break;
                }
            }

            DecimalFormat format = new DecimalFormat("#.#");
            double health = k.getHealth();
            health /= 2.0D;

            Skypvp.getInstance().getMessager().send(p, "§7Du wurdest von §6" + k.getDisplayName() + " §8[§c❤"+format.format(health)+"§8] §7getötet §8[§c-1 Coins§8]");
            Skypvp.getInstance().getMessager().send(k, "§7Du hast §6" + p.getDisplayName() + " §7getötet §8[§a+3 Coins§8]");
        } else {
            if(cp.getCoins() >= 3) cp.removeCoins(3);
            cp.getStats(Gamemode.SKYPVP).addDeaths(1);

            Skypvp.getInstance().getMessager().send(p, "§7Du bist gestorben §8[§c-3 Coins§8]");
        }
    }

}
