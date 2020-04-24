/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.player.Kit;
import eu.mcone.skypvp.player.KitManager;
import eu.mcone.skypvp.player.SkypvpPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.text.DecimalFormat;

public class PlayerDeathListener implements Listener{

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        Player k = p.getKiller() != null ? p.getKiller() : Skypvp.getInstance().getDamageLogger().getKiller(p);

        e.setDeathMessage(null);
        e.setKeepInventory(false);
        e.getDrops().clear();
        p.setLevel(0);

        p.setVelocity(new Vector(0, 0, 0));
        p.spigot().respawn();

        if(k != null){
            CorePlayer ck = CoreSystem.getInstance().getCorePlayer(k);

            ck.addCoins(3);
            ck.getStats(Gamemode.SKYPVP).addKills(1);
            k.setLevel(k.getLevel()+1);
            k.addPotionEffect(PotionEffectType.REGENERATION.createEffect(20*20, 3));

            for (int streak : new int[]{3,5,10,15,20,25,30,35,40,50,55,60}) {
                if (p.getLevel() == streak) {
                    Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§f" + p.getName() + " §6hat eine §c"+streak+"er §6Killstreak!");
                    break;
                }
            }

            DecimalFormat format = new DecimalFormat("#.#");
            double health = k.getHealth();
            health /= 2.0D;

            Skypvp.getInstance().getMessenger().send(p, "§7Du wurdest von §6" + k.getDisplayName() + " §8[§c❤"+format.format(health)+"§8] §7getötet §8[§c-1 Coins§8]");
            Skypvp.getInstance().getMessenger().send(k, "§7Du hast §6" + p.getDisplayName() + " §7getötet §8[§a+3 Coins§8]");
            if(cp.getCoins() > 0) cp.removeCoins(1);
        } else {
            if(cp.getCoins() >= 3) cp.removeCoins(3);
            cp.getStats(Gamemode.SKYPVP).addDeaths(1);

            Skypvp.getInstance().getMessenger().send(p, "§7Du bist gestorben §8[§c-3 Coins§8]");
        }

        p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1.0F, 1.0F);
        cp.getStats(Gamemode.SKYPVP).addDeaths(1);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        final Player p = e.getPlayer();

        e.setRespawnLocation(Skypvp.getInstance().getWorld().getLocation("spawn"));

        p.setFireTicks(0);

        Bukkit.getScheduler().scheduleSyncDelayedTask(Skypvp.getInstance(), () -> {
            p.getInventory().clear();

            SkypvpPlayer sp = Skypvp.getInstance().getSkypvpPlayer(p.getUniqueId());
            sp.resetCurrentKit();
            KitManager.setKit(sp, Kit.PLAYER);
        });
    }

}
