/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.skypvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEntity implements Listener {

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
            if (!p.getGameMode().equals(GameMode.CREATIVE)) {
                ItemFrame itemframe = (ItemFrame) ent;
                e.setCancelled(true);
                openFreeItemsInventory(p, itemframe.getItem());
            }
        }

    }

    private void openFreeItemsInventory(Player p, ItemStack item){
        Inventory inv = Bukkit.createInventory(null, 27, Main.config.getConfigValue("System-ItemFrame"));
        if (item.getMaxStackSize() > 1) {
            item.setAmount(10);
        }
        inv.setItem(13, item);
        p.openInventory(inv);
    }

}