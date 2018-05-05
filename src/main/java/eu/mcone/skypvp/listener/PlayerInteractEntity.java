/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
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

        if (ent instanceof ItemFrame){
            if (!p.getGameMode().equals(GameMode.CREATIVE)) {
                ItemFrame itemframe = (ItemFrame) ent;
                e.setCancelled(true);
                openFreeItemsInventory(p, itemframe.getItem());
            }
        } else if (e.getRightClicked() instanceof Player) {
            Player clicked = (Player) e.getRightClicked();
            if (clicked.getDisplayName().equals("§8» §c§lShop")) {
                p.performCommand("shop");
            } else if (clicked.getDisplayName().equals("§8» §c§lKits")) {
                p.performCommand("kit");
            }
        }

    }

    private void openFreeItemsInventory(Player p, ItemStack item){
        Inventory inv = Bukkit.createInventory(null, 27, CoreSystem.getInstance().getTranslationManager().get("skypvp.itemframe"));
        if (item.getMaxStackSize() > 1) {
            item.setAmount(10);
        }
        inv.setItem(13, item);
        p.openInventory(inv);
    }

}
