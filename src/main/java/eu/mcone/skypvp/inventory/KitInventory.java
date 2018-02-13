/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.inventory;

import eu.mcone.coresystem.bukkit.util.ItemFactory;
import eu.mcone.skypvp.SkyPvP;
import eu.mcone.skypvp.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class KitInventory {

    public static void open(Player p) {
        Inventory inv = Bukkit.getServer().createInventory(null, 27, "§8Wähle dein Kit");

        for (int i = 0; i <= 26; i++) {
            inv.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
        }

        SkyPvP.kits.setInvItem(inv, p, Kit.PLAYER, 10);
        SkyPvP.kits.setInvItem(inv, p, Kit.IRON, 12);
        SkyPvP.kits.setInvItem(inv, p, Kit.DIAMOND, 14);
        SkyPvP.kits.setInvItem(inv, p, Kit.EMERALD, 16);

        p.openInventory(inv);
    }

    public static void click(InventoryClickEvent e, Player p) {
        for (Kit k : Kit.values()) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(k.getName())) {
                if (SkyPvP.kits.hasKit(p, k)) {
                    SkyPvP.kits.setKit(p, k);
                    p.closeInventory();
                } else {
                    KitBuyInventory.open(p, k);
                }
                return;
            }
        }
    }

}
