/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.inventory;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.skypvp.Skypvp;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ShopInventory extends CoreInventory {

    public ShopInventory(Player p) {
        super("§9§lSkyPvP §8» §fShop", p, 27, InventoryOption.FILL_EMPTY_SLOTS);

        setItem(9, ShopItem.swords.getItem(), e -> new WeaponInventory(p));
        setItem(11, ShopItem.bows.getItem(), e -> new BowInventory(p));
        setItem(13, ShopItem.armor.getItem(), e -> new ArmorInventory(p));
        setItem(15, ShopItem.extras.getItem(), e -> new ExtraInventory(p));
        setItem(17, ShopItem.special.getItem(), e -> new SpecialInventory(p));

        openInventory();
    }

    private void setInvItem(CoreInventory inv, int slot, ShopItem item) {
        inv.setItem(slot, item.getItem(), e -> buyShopItem(inv.getPlayer(), item));
    }

    private void buyShopItem(Player p, ShopItem item) {
        int futCoins = CoreSystem.getInstance().getCorePlayer(p).getCoins() - item.getCoins();
        if (futCoins <= -1) {
            p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            CoreSystem.getInstance().createTitle()
                    .title("§c§l×")
                    .subTitle("§7Du hast nicht genügend §fCoins§7!")
                    .fadeIn(1)
                    .stay(2)
                    .fadeOut(1)
                    .send(p);
        } else {
            CoreSystem.getInstance().getCorePlayer(p).removeCoins(item.getCoins());
            p.getInventory().addItem(item.getItem());
            new ShopInventory(p);

            p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
            Skypvp.getInstance().getMessager().send(p, "§2Du hast erfolgreich das Item §a" + item.getItem().getItemMeta().getDisplayName() + "§2 gekauft!");
            CoreSystem.getInstance().createTitle()
                    .title("§a§l✓")
                    .subTitle("§7Du hast das Item §f" + item.getItem().getItemMeta().getDisplayName() + " §7gekauft!")
                    .fadeIn(1)
                    .stay(2)
                    .fadeOut(1)
                    .send(p);
        }
    }

    private class WeaponInventory extends CoreInventory {
        WeaponInventory(Player p) {
            super("§f§lShop §8- §cWaffen", p, 36, InventoryOption.FILL_EMPTY_SLOTS);

            setInvItem(this, 9, ShopItem.sword1);
            setInvItem(this, 11, ShopItem.sword2);
            setInvItem(this, 13, ShopItem.sword3);
            setInvItem(this, 15, ShopItem.sword4);
            setInvItem(this, 17, ShopItem.sword5);

            setReturnItem(p);

            openInventory();
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        }
    }

    private class BowInventory extends CoreInventory {
        BowInventory(Player p) {
            super("§f§lShop §8- §cBögen", p, 36, InventoryOption.FILL_EMPTY_SLOTS);

            setInvItem(this, 9, ShopItem.bow1);
            setInvItem(this, 11, ShopItem.bow2);
            setInvItem(this, 13, ShopItem.bow3);
            setInvItem(this, 15, ShopItem.bow4);
            setInvItem(this, 17, ShopItem.bow5);

            setReturnItem(p);

            openInventory();
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        }
    }

    private class ArmorInventory extends CoreInventory {
        ArmorInventory(Player p) {
            super("§f§lShop §8- §cRüstung", p, 36, InventoryOption.FILL_EMPTY_SLOTS);

            setInvItem(this, 3, ShopItem.helm1);
            setInvItem(this, 4, ShopItem.helm2);
            setInvItem(this, 5, ShopItem.helm3);
            setInvItem(this, 6, ShopItem.helm4);

            setInvItem(this, 12, ShopItem.chest1);
            setInvItem(this, 13, ShopItem.chest2);
            setInvItem(this, 14, ShopItem.chest3);
            setInvItem(this, 15, ShopItem.chest4);

            setInvItem(this, 21, ShopItem.leggin1);
            setInvItem(this, 22, ShopItem.leggin2);
            setInvItem(this, 23, ShopItem.leggin3);
            setInvItem(this, 24, ShopItem.leggin4);

            setInvItem(this, 30, ShopItem.shoe1);
            setInvItem(this, 31, ShopItem.shoe2);
            setInvItem(this, 32, ShopItem.shoe3);
            setInvItem(this, 33, ShopItem.shoe4);

            setReturnItem(p);

            openInventory();
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        }
    }

    private class ExtraInventory extends CoreInventory {
        ExtraInventory(Player p) {
            super("§f§lShop §8- §cExtras", p, 36, InventoryOption.FILL_EMPTY_SLOTS);

            setInvItem(this, 9, ShopItem.op1);
            setInvItem(this, 11, ShopItem.op2);
            setInvItem(this, 13, ShopItem.op3);
            setInvItem(this, 15, ShopItem.op4);
            setInvItem(this, 17, ShopItem.op5);

            setReturnItem(p);

            openInventory();
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        }
    }

    private class SpecialInventory extends CoreInventory {
        SpecialInventory(Player p) {
            super("§f§lShop §8- §cSpezial", p, 36, InventoryOption.FILL_EMPTY_SLOTS);

            setInvItem(this, 10, ShopItem.axe1);
            setInvItem(this, 13, ShopItem.soup);
            setInvItem(this, 16, ShopItem.axe2);

            setReturnItem(p);

            openInventory();
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
        }
    }

    private void setReturnItem(Player player) {
        setItem(31, new ItemBuilder(Material.IRON_DOOR, 1, 0).displayName("§7§l↩ Zurück").create(), e -> {
            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            new ShopInventory(player);
        });
    }

}
