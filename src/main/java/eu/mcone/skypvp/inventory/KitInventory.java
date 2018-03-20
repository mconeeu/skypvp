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
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class KitInventory extends CoreInventory {

    public KitInventory(Player p) {
        super("§8Wähle dein Kit", p, 27, Option.FILL_EMPTY_SLOTS);

        SkyPvP.getInstance().getKitManager().setInvItem(this, p, Kit.PLAYER, 10);
        SkyPvP.getInstance().getKitManager().setInvItem(this, p, Kit.IRON, 12);
        SkyPvP.getInstance().getKitManager().setInvItem(this, p, Kit.DIAMOND, 14);
        SkyPvP.getInstance().getKitManager().setInvItem(this, p, Kit.EMERALD, 16);

        openInventory();
    }

}
