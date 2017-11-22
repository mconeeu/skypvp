/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.event;

import de.Dominik.SkyPvP.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEntity_Event implements Listener {

    @EventHandler
    public void on(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        Entity ent = e.getRightClicked();

        if(ent instanceof Villager) {
            Villager i = (Villager) ent;
            e.setCancelled(true);

            if(i.getCustomName().equalsIgnoreCase("§9SkyPvP §8» §cShop")) {
                i.setCustomNameVisible(true);
                p.performCommand("shop");
            } else if(i.getCustomName().equalsIgnoreCase("§9SkyPvP §8» §cKits")) {
                i.setCustomNameVisible(true);
                p.performCommand("kit");
            }
        } else if (ent instanceof ItemFrame){
            ItemFrame itemframe = (ItemFrame) ent;
            e.setCancelled(true);
            openInventory(p, itemframe.getItem(), 10);
        }

    }

    private void openInventory(Player p, ItemStack item, int anzahl){
        Inventory inv = Bukkit.createInventory(null, 27, Main.config.getConfigValue("System-ItemFrame"));
        if (item.getMaxStackSize() > 1) {
            item.setAmount(anzahl);
        }
        inv.setItem(13, item);
        p.openInventory(inv);
    }

}
