/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.bukkit.api.CoinsAPI;
import eu.mcone.coresystem.bukkit.api.TitleAPI;
import eu.mcone.skypvp.inventory.KitBuyInventory;
import eu.mcone.skypvp.inventory.KitInventory;
import eu.mcone.skypvp.inventory.ShopInventory;
import eu.mcone.skypvp.inventory.ShopItem;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {
	  
	@EventHandler
	public void on(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();

        if((e.getRawSlot() < e.getInventory().getSize()) && (e.getCurrentItem() != null)){
            if (e.getClickedInventory().getTitle().equalsIgnoreCase("§8Wähle dein Kit")){
                e.setCancelled(true);
                KitInventory.click(e, p);
            } else if (e.getInventory().getName().equalsIgnoreCase("§9§lSkyPvP §8» §fShop")) {
                e.setCancelled(true);
                ShopInventory.click(e, p);
            } else if (
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cWaffen") ||
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cBögen") ||
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cRüstung") ||
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cExtras") ||
                    e.getInventory().getName().equalsIgnoreCase("§f§lShop §8- §cSpezial")
                    ) {
                e.setCancelled(true);
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§l↩ Zurück")) {
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
                    ShopInventory.open(p);
                }

                for (ShopItem item : ShopItem.values()) {
                    if (e.getCurrentItem().equals(item.getItem())) {
                        buyShopItem(p, item);
                    }
                }
            } else if (e.getInventory().getName().equalsIgnoreCase("§8» §3Kit kaufen")) {
                e.setCancelled(true);
                KitBuyInventory.click(e, p);
            }
        }
	}

    private void buyShopItem(Player p, ShopItem item){
        int futCoins = CoinsAPI.getCoins(p.getUniqueId()) - item.getCoins();
        if (futCoins <= -1){
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            TitleAPI.sendTitle(p, "§c§l×", "§7Du hast nicht genügend §fCoins§7!", 1, 2, 1);
        } else {
            CoinsAPI.removeCoins(p.getUniqueId(), item.getCoins());
            p.getInventory().addItem(item.getItem());
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
            TitleAPI.sendTitle(p, "§a§l✓", "§7Du hast das Item §f" + item.getItem().getItemMeta().getDisplayName() + " §7gekauft!", 1, 2, 1);
        }
    }
}
