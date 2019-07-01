/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.inventory;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.player.Kit;
import org.bukkit.entity.Player;

public class KitInventory extends CoreInventory {

    public KitInventory(Player p) {
        super("§8Wähle dein Kit", p, 27, InventoryOption.FILL_EMPTY_SLOTS);

        Skypvp.getInstance().getKitManager().setInvItem(this, p, Kit.PLAYER, 10);
        Skypvp.getInstance().getKitManager().setInvItem(this, p, Kit.IRON, 12);
        Skypvp.getInstance().getKitManager().setInvItem(this, p, Kit.DIAMOND, 14);
        Skypvp.getInstance().getKitManager().setInvItem(this, p, Kit.EMERALD, 16);

        openInventory();
    }

}
