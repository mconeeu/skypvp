/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.inventory;

import eu.mcone.bukkitcoresystem.util.ItemManager;
import eu.mcone.skypvp.Main;
import eu.mcone.skypvp.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Arrays;

public class KitBuyInventory {

    static void open(Player p, Kit kit) {
        Inventory inv = Bukkit.createInventory(null, 27, "§8» §3Kit kaufen");

        for (int i = 0; i <= 26; i++) {
            inv.setItem(i, ItemManager.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
        }
        inv.setItem(4, ItemManager.createItem(kit.getItem(), 0, 1, kit.getName(), new ArrayList<>(Arrays.asList("", "§7§oKostet: §f§o" + kit.getCoins() + " Coins")), true));
        inv.setItem(21, ItemManager.createItem(Material.STAINED_GLASS_PANE, 5, 1, "§a§lKit kaufen", new ArrayList<>(Arrays.asList("", "§8» §a§nRechtsklick§8 | §7§oKaufen")), true));
        inv.setItem(23, ItemManager.createItem(Material.STAINED_GLASS_PANE, 14, 1, "§c§lAbbrechen", new ArrayList<>(Arrays.asList("", "§8» §c§nRechtsklick§8 | §7§oAbbrechen")), true));

        p.openInventory(inv);
        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
    }

    public static void click(InventoryClickEvent e, Player p) {
        if ((e.getCurrentItem() == null) || !e.getCurrentItem().hasItemMeta() || e.getSlotType() == InventoryType.SlotType.OUTSIDE) {
            e.setCancelled(true);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lKit kaufen")){
            Main.kits.buyAndSet(p, Kit.getKitByName(e.getInventory().getItem(4).getItemMeta().getDisplayName()));
            p.closeInventory();
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lAbbrechen")){
            KitInventory.open(p);
            p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
        }
    }

}
