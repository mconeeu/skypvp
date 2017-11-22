/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.event;

import de.Dominik.BukkitCoreSystem.api.CoinsAPI;
import de.Dominik.SkyPvP.Main;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;

import static de.Dominik.BukkitCoreSystem.Main.statsSkypvp;

public class PlayerDeath_Event implements Listener {

    private static HashMap<Player, Player> lastHit = new HashMap<>();

    @EventHandler
    public void on(PlayerDeathEvent e) {
        try{
            Player p = e.getEntity();
            Player k = p.getKiller();
            lastHit.put(k, p);

            EntityPlayer en = ((CraftPlayer) p).getHandle();
            en.getLastDamager();

            e.setDeathMessage(null);
            e.getDrops().clear();
            respawn(p, 1);
            p.setLevel(0);

            p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1.0F, 1.0F);

            if(k != null){
                int coins = CoinsAPI.getCoins(p);
                if(coins >= 3){
                    //Coins werden dem Spieler Angezogen (3)
                    CoinsAPI.removeCoins(p, 3);
                }

                //Tode werden dem Spieler Hinzugefügt (1)
                statsSkypvp.addDeaths(p.getUniqueId().toString(), p.getName(), 1);

                int i = k.getLevel();
                i++;
                k.setLevel(i);
                checkLevel(i, k);

                //Coins werden dem Killer Hinzugefügt (3)
                CoinsAPI.addCoins(k, 3);

                //Kills werden dem Killer Hinzugefügt (1)
                statsSkypvp.addKills(k.getUniqueId().toString(), k.getName(), 1);

                p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du wurdest von §6" + k.getDisplayName() + " §7getötet");

                k.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du hast §6" + p.getDisplayName() + " §7getötet");

            } else {
                int coins = CoinsAPI.getCoins(p);
                if(coins >= 3){
                    //Coins werden dem Spieler Angezogen (3)
                    CoinsAPI.removeCoins(p, 3);
                }
                //Tod wird dem Spieler hinzugefügt
                statsSkypvp.addDeaths(p.getUniqueId().toString(), p.getName(), 1);

                p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§7Du bist gestorben");
            }

            if(lastHit.containsKey(p)) {
                lastHit.get(p);
                lastHit.remove(p);
            }
        }catch(NullPointerException e1){
            e1.printStackTrace();
        }
    }

    private void checkLevel(int i, Player p){

        if (i == 3) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c3er §6Killstreak!");
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§eDu hast 10 coins erhalten!");
            //Coins werden dem Spieler Hinzugefügt (10)
            CoinsAPI.addCoins(p, 10);

        }

        if (i == 5) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c5er §6Killstreak!");
        }
        if (i == 10) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c10er §6Killstreak!");
        }
        if (i == 15) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c15er §6Killstreak!");
        }
        if (i == 20) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c20er §6Killstreak!");
        }
        if (i == 25) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c25er §6Killstreak!");
        }
        if (i == 30) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c30er §6Killstreak!");
        }
        if (i == 35) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c35er §6Killstreak!");
        }
        if (i == 40) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c40er §6Killstreak!");
        }
        if (i == 45) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c45er §6Killstreak!");
        }
        if (i == 50) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c50er §6Killstreak!");
        }
        if (i == 55) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c55er §6Killstreak!");
        }
        if (i == 60) {
            Bukkit.broadcastMessage(Main.config.getConfigValue("System-Prefix") + "§e" + p.getName() + " §6hat eine §c60er §6Killstreak!");
        }
    }

    private void respawn(final Player player, int Time) {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> (
                (CraftPlayer)player).getHandle().playerConnection.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN)
        ), Time);
    }

}
