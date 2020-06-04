/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.PlayerInventorySlot;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.util.CoreActionBar;
import eu.mcone.gameapi.api.event.player.GamePlayerLoadedEvent;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.player.Kit;
import eu.mcone.skypvp.player.SkypvpPlayer;
import eu.mcone.skypvp.util.SidebarObjective;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;

import static com.mongodb.client.model.Filters.eq;

public class GeneralPlayerListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + CoreSystem.getInstance().getTranslationManager().get("skypvp.join").replaceAll("%player%", p.getName()));
        p.getInventory().clear();
        p.setFoodLevel(20);
        Skypvp.getInstance().getWorld().teleportSilently(p, "spawn");
    }

    @EventHandler
    public void onJoin(GamePlayerLoadedEvent e) {
        Player p = e.getBukkitPlayer();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        new SkypvpPlayer(cp);
        cp.getScoreboard().setNewObjective(new SidebarObjective());

        if (CoreSystem.getInstance().getMongoDB().getCollection("skypvp_profile").find(eq("uuid", p.getUniqueId().toString())).first() == null) {
            Skypvp.getInstance().getMessenger().send(p, "§7Du scheinst neu auf SkyPvP zu sein! Du bekommst das Standart-Kit!");
            GamePlayer gamePlayer = Skypvp.getInstance().getGamePlayer(p);
            gamePlayer.setKit(Kit.DEFAULT);
        }

        p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10);
    }

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        e.setCancelled(true);
        Skypvp.getInstance().getMessenger().send(p, "§cHier darf man kein Bett benutzen!");
    }

    @EventHandler(priority = EventPriority.LOW)
    public void on(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        p.setLevel(0);
        e.setQuitMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + CoreSystem.getInstance().getTranslationManager().get("skypvp.quit").replaceAll("%player%", p.getName()));

        SkypvpPlayer sp = Skypvp.getInstance().getSkypvpPlayer(p.getUniqueId());

        sp.saveData();
        Skypvp.getInstance().unregisterSkypvpPlayer(sp);
    }

    @EventHandler
    public void on(WeatherChangeEvent e) {
        if (e.toWeatherState()) {
            e.setCancelled(true);
        }
    }

    private boolean hasEmptyInventory(Player p) {
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null) {
                return false;
            }
        }
        return true;
    }

}
