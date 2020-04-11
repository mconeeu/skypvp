/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.player;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.inventory.KitBuyInventory;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

public class KitManager {

    public static void setKit(SkypvpPlayer p, Kit kit) {
        Player bp = p.bukkit();

        if (!p.hasKit(kit)){
            Skypvp.getInstance().getMessager().send(bp, "§4Du besitzt dieses Kit nicht!");
        } else if (p.getCurrentKit() != null && !p.getCurrentKit().equals(Kit.PLAYER)) {
            Skypvp.getInstance().getMessager().send(bp, "§4Du hast bereits ein Kit ausgewählt! Du kannst erst wieder wechseln, nachdem du einmal gestorben bist!");
        } else {
            if (kit.equals(Kit.PLAYER)) {
                bp.getInventory().setItem(0, new ItemBuilder(Material.STONE_SWORD, 1, 0).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                bp.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, 0).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                bp.getInventory().setItem(2, new ItemBuilder(Material.COOKED_CHICKEN, 20, 0).create());
                bp.getInventory().setItem(7, new ItemBuilder(Material.GOLDEN_APPLE, 1, 0).create());
                bp.getInventory().setItem(8, new ItemBuilder(Material.ENDER_PEARL, 16, 0).create());

                bp.getInventory().setHelmet(new ItemBuilder(Material.CHAINMAIL_HELMET, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                bp.getInventory().setChestplate(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                bp.getInventory().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                bp.getInventory().setBoots(new ItemBuilder(Material.CHAINMAIL_BOOTS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
            } else if (kit.equals(Kit.IRON)) {
                if (p.hasKit(Kit.IRON)) {
                    bp.getInventory().setItem(0, new ItemBuilder(Material.IRON_SWORD, 1, 0).enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, 0).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setItem(2, new ItemBuilder(Material.COOKED_CHICKEN, 20, 0).create());
                    bp.getInventory().setItem(7, new ItemBuilder(Material.GOLDEN_APPLE, 5, 0).create());
                    bp.getInventory().setItem(8, new ItemBuilder(Material.ENDER_PEARL, 16, 0).create());

                    bp.getInventory().setHelmet(new ItemBuilder(Material.IRON_HELMET, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setChestplate(new ItemBuilder(Material.IRON_CHESTPLATE, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setLeggings(new ItemBuilder(Material.IRON_LEGGINGS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setBoots(new ItemBuilder(Material.IRON_BOOTS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                } else {
                    Skypvp.getInstance().getMessager().send(bp, "§4Du besitzt das §cEisen-Kit §4nicht");
                    return;
                }
            } else if (kit.equals(Kit.DIAMOND)) {
                if (p.hasKit(Kit.DIAMOND)) {
                    bp.getInventory().setItem(0, new ItemBuilder(Material.IRON_SWORD, 1, 0).enchantment(Enchantment.DAMAGE_ALL, 2).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, 0).enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setItem(2, new ItemBuilder(Material.COOKED_CHICKEN, 20, 0).create());
                    bp.getInventory().setItem(7, new ItemBuilder(Material.GOLDEN_APPLE, 8, 0).create());
                    bp.getInventory().setItem(8, new ItemBuilder(Material.ENDER_PEARL, 16, 0).create());

                    bp.getInventory().setHelmet(new ItemBuilder(Material.IRON_HELMET, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setChestplate(new ItemBuilder(Material.IRON_CHESTPLATE, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setLeggings(new ItemBuilder(Material.IRON_LEGGINGS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setBoots(new ItemBuilder(Material.IRON_BOOTS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                } else {
                    Skypvp.getInstance().getMessager().send(bp, "§4Du besitzt das §cDiamond-Kit §4nicht");
                    return;
                }
            } else if (kit.equals(Kit.EMERALD)) {
                if (p.hasKit(Kit.EMERALD)) {
                    bp.getInventory().setItem(0, new ItemBuilder(Material.DIAMOND_SWORD, 1, 0).enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, 0).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setItem(2, new ItemBuilder(Material.COOKED_CHICKEN, 20, 0).create());
                    bp.getInventory().setItem(7, new ItemBuilder(Material.GOLDEN_APPLE, 15, 0).create());
                    bp.getInventory().setItem(8, new ItemBuilder(Material.ENDER_PEARL, 16, 0).create());

                    bp.getInventory().setHelmet(new ItemBuilder(Material.DIAMOND_HELMET, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setLeggings(new ItemBuilder(Material.DIAMOND_LEGGINGS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    bp.getInventory().setBoots(new ItemBuilder(Material.DIAMOND_BOOTS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                } else {
                    Skypvp.getInstance().getMessager().send(bp, "§4Du besitzt das §cEmerald-Kit §4nicht");
                    return;
                }
            }

            p.setCurrentKit(kit);

            bp.playSound(bp.getLocation(), Sound.LEVEL_UP, 1, 1);
            Skypvp.getInstance().getMessager().send(bp, "§2Du hast das Kit " + kit.getName() + " §2erhalten");
        }
    }

    public static void setInvItem(CoreInventory inv, Player p, Kit kit, int i) {
        SkypvpPlayer sp = Skypvp.getInstance().getSkypvpPlayer(p.getUniqueId());

        if (sp.hasKit(kit)) {
            inv.setItem(i, new ItemBuilder(kit.getItem(), 1, 0).displayName(kit.getName()).lore("§r", "§2§oDu besitzt dieses Item!", "§8» §f§nRechtsklick§8 | §7§oAktivieren").create(), e -> {
                setKit(sp, kit);
                p.closeInventory();
            });
        } else {
            inv.setItem(i, new ItemBuilder(kit.getItem(), 1, 0).displayName(kit.getName()).lore("§r", "§c§oDu besitzt dieses Item nicht!", "§7§oKostet: §f§o" + kit.getCoins() + " Coins").create(), e ->
                    new KitBuyInventory(p, kit));
        }
    }

}
