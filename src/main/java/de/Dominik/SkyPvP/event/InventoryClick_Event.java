/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.event;

import de.Dominik.BukkitCoreSystem.api.CoinsAPI;
import de.Dominik.BukkitCoreSystem.api.TitleAPI;
import de.Dominik.BukkitCoreSystem.util.ItemManager;
import de.Dominik.SkyPvP.inventory.KitInventory;
import de.Dominik.SkyPvP.inventory.ShopInventory;
import de.Dominik.SkyPvP.inventory.ShopItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.Dominik.SkyPvP.Main;

import java.util.HashMap;

public class InventoryClick_Event implements Listener {
	  
	@EventHandler
	public void on(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();

        if((e.getRawSlot() < e.getInventory().getSize()) && (e.getCurrentItem() != null) && (!e.getInventory().getTitle().contains("Free Items")) && (!e.getInventory().getTitle().contains(""))){
            e.setCancelled(true);

            if (e.getClickedInventory().getTitle().equalsIgnoreCase("§8Wähle dein Kit")){
                KitInventory.click(e, p);
            } else if (e.getInventory().getName().equalsIgnoreCase("§9§lSkyPvP §8» §fShop")) {
                ShopInventory.click(e, p);
            } else if (
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cWaffen") ||
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cBögen") ||
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cRüstung") ||
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cExtras") ||
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cSpezial")
                    ) {

                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§l↩ Zurück")) {
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
                    ShopInventory.open(p);
                }

                for (ShopItem item : ShopItem.values()) {
                    if (e.getCurrentItem().equals(item.getItem())) {
                        buyShopItem(p, item);
                    }
                }
            }
        }
	}

    private void buyShopItem(Player p, ShopItem item){
        int futCoins = CoinsAPI.getCoins(p) - item.getCoins();
        if (futCoins <= -1){
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            TitleAPI.sendTitle(p, "§c§l×", "§7Du hast nicht genügend §fCoins§7!", 1, 2, 1);
        } else {
            CoinsAPI.removeCoins(p, item.getCoins());
            p.getInventory().addItem(ShopItem.schwert1.getItem());
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
            TitleAPI.sendTitle(p, "§a§l✓", "§7Du hast das Item §f" + item.getItem().getItemMeta().getDisplayName() + " §7gekauft!", 1, 2, 1);
        }
    }
}
