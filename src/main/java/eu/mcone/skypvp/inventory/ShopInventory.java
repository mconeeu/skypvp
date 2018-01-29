/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.inventory;

import eu.mcone.bukkitcoresystem.util.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class ShopInventory {

    public static void open(Player p) {
        Inventory inv = Bukkit.createInventory(p, 27, "§9§lSkyPvP §8» §fShop");

        for (int i = 0; i <= 26; i++) {
            inv.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
        }

        inv.setItem(9, ShopItem.schwerter.getItem());
        inv.setItem(11, ShopItem.boegen.getItem());
        inv.setItem(13, ShopItem.ruestung.getItem());
        inv.setItem(15, ShopItem.extras.getItem());
        inv.setItem(17, ShopItem.spezial.getItem());

        p.openInventory(inv);
    }

    public static void click(InventoryClickEvent e, Player p) {
        Inventory waffengui = Bukkit.createInventory(p, 36, "§f§lShop §8- §cWaffen");
        Inventory boegengui = Bukkit.createInventory(p, 36, "§f§lShop §8- §cBögen");
        Inventory ruestunggui = Bukkit.createInventory(p, 36, "§f§lShop §8- §cRüstung");
        Inventory extragui = Bukkit.createInventory(p, 36, "§f§lShop §8- §cExtras");
        Inventory spezialgui = Bukkit.createInventory(p, 36, "§f§lShop §8- §cSpezial");

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchwerter")) {
            for (int i = 0; i <= 35; i++) {
                waffengui.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
            }

            waffengui.setItem(9, ShopItem.schwert1.getItem());
            waffengui.setItem(11, ShopItem.schwert2.getItem());
            waffengui.setItem(13, ShopItem.schwert3.getItem());
            waffengui.setItem(15, ShopItem.schwert4.getItem());
            waffengui.setItem(17, ShopItem.schwert5.getItem());

            waffengui.setItem(31, ItemFactory.createItem(Material.IRON_DOOR, 0, 1, "§7§l↩ Zurück", true));

            p.openInventory(waffengui);
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBögen")) {
            for (int i = 0; i <= 35; i++) {
                boegengui.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
            }

            boegengui.setItem(9, ShopItem.bogen1.getItem());
            boegengui.setItem(11, ShopItem.bogen2.getItem());
            boegengui.setItem(13, ShopItem.bogen3.getItem());
            boegengui.setItem(15, ShopItem.bogen4.getItem());
            boegengui.setItem(17, ShopItem.bogen5.getItem());

            boegengui.setItem(31, ItemFactory.createItem(Material.IRON_DOOR, 0, 1, "§7§l↩ Zurück", true));

            p.openInventory(boegengui);
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRüstung")) {
            for (int i = 0; i <= 35; i++) {
                ruestunggui.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
            }

            ruestunggui.setItem(3, ShopItem.helm1.getItem());
            ruestunggui.setItem(4, ShopItem.helm2.getItem());
            ruestunggui.setItem(5, ShopItem.helm3.getItem());
            ruestunggui.setItem(6, ShopItem.helm4.getItem());

            ruestunggui.setItem(12, ShopItem.brust1.getItem());
            ruestunggui.setItem(13, ShopItem.brust2.getItem());
            ruestunggui.setItem(14, ShopItem.brust3.getItem());
            ruestunggui.setItem(15, ShopItem.brust4.getItem());

            ruestunggui.setItem(21, ShopItem.hose1.getItem());
            ruestunggui.setItem(22, ShopItem.hose2.getItem());
            ruestunggui.setItem(23, ShopItem.hose3.getItem());
            ruestunggui.setItem(24, ShopItem.hose4.getItem());

            ruestunggui.setItem(30, ShopItem.schuhe1.getItem());
            ruestunggui.setItem(31, ShopItem.schuhe2.getItem());
            ruestunggui.setItem(32, ShopItem.schuhe3.getItem());
            ruestunggui.setItem(33, ShopItem.schuhe4.getItem());

            ruestunggui.setItem(27, ItemFactory.createItem(Material.IRON_DOOR, 0, 1, "§7§l↩ Zurück", true));

            p.openInventory(ruestunggui);
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cExtras")) {
            for (int i = 0; i <= 35; i++) {
                extragui.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
            }

            extragui.setItem(9, ShopItem.op1.getItem());
            extragui.setItem(11, ShopItem.op2.getItem());
            extragui.setItem(13, ShopItem.op3.getItem());
            extragui.setItem(15, ShopItem.op4.getItem());
            extragui.setItem(17, ShopItem.op5.getItem());

            extragui.setItem(31, ItemFactory.createItem(Material.IRON_DOOR, 0, 1, "§7§l↩ Zurück", true));

            p.openInventory(extragui);
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSpezial")) {
            for (int i = 0; i <= 35; i++) {
                spezialgui.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
            }

            spezialgui.setItem(10, ShopItem.axt1.getItem());
            spezialgui.setItem(13, ShopItem.soup.getItem());
            spezialgui.setItem(16, ShopItem.axt2.getItem());

            spezialgui.setItem(31, ItemFactory.createItem(Material.IRON_DOOR, 0, 1, "§7§l↩ Zurück", true));

            p.openInventory(spezialgui);
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        }
    }

}
