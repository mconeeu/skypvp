/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.inventory;

import eu.mcone.coresystem.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.bukkit.util.ItemFactory;
import eu.mcone.skypvp.SkyPvP;
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

public class KitBuyInventory extends CoreInventory {

    public KitBuyInventory(Player p, Kit kit) {
        super("§8» §3Kit kaufen", p, 27, Option.FILL_EMPTY_SLOTS);

        setItem(4, ItemFactory.createItem(kit.getItem(), 0, 1, kit.getName(), new ArrayList<>(Arrays.asList("", "§7§oKostet: §f§o" + kit.getCoins() + " Coins")), true));
        setItem(21, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 5, 1, "§a§lKit kaufen", new ArrayList<>(Arrays.asList("", "§8» §a§nRechtsklick§8 | §7§oKaufen")), true), () -> {
            SkyPvP.getInstance().getKitManager().buyAndSet(p, kit);
            p.closeInventory();
        });
        setItem(23, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 14, 1, "§c§lAbbrechen", new ArrayList<>(Arrays.asList("", "§8» §c§nRechtsklick§8 | §7§oAbbrechen")), true), () -> {
            new KitInventory(p);
            p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
        });

        openInventory();
        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
    }

}
