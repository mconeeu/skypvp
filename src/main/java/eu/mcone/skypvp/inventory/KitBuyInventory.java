/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.inventory;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.kit.Kit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class KitBuyInventory extends CoreInventory {

    public KitBuyInventory(Player p, Kit kit) {
        super("§8» §3Kit kaufen", p, 27, CoreInventory.Option.FILL_EMPTY_SLOTS);

        setItem(4, new ItemBuilder(kit.getItem(), 1, 0).displayName(kit.getName()).lore("", "§7§oKostet: §f§o" + kit.getCoins() + " Coins").create());
        setItem(21, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 5).displayName("§a§lKit kaufen").lore("", "§8» §a§nRechtsklick§8 | §7§oKaufen").create(), () -> {
            Skypvp.getInstance().getKitManager().buyAndSet(p, kit);
            p.closeInventory();
        });
        setItem(23, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 14).displayName("§c§lAbbrechen").lore("", "§8» §c§nRechtsklick§8 | §7§oAbbrechen").create(), () -> {
            new KitInventory(p);
            p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
        });

        openInventory();
        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
    }

}
