/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.inventory;

import eu.mcone.coresystem.bukkit.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public enum ShopItem {

    swords(new ItemBuilder(Material.DIAMOND_SWORD, 1, 0).displayName("§cSchwerter").lore("§8» §7Abteil mit Schwertern.").create(), 0),
    bows(new ItemBuilder(Material.BOW, 1, 0).displayName("§cBögen").lore("§8» §7Abteil mit Bögen.").create(), 0),
    armor(new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).displayName("§cRüstung").lore("§8» §7Abteil mit Rüstung.").create(), 0),
    extras(new ItemBuilder(Material.NETHER_STAR, 1, 0).displayName("§cExtras").lore("§8» §7Abteil mit Extras.").create(), 0),
    special(new ItemBuilder(Material.TNT, 1, 0).displayName("§cSpezial").lore("§8» §7Abteil mit Spezial Items.").create(), 0),

    sword1(new ItemBuilder(Material.DIAMOND_SWORD, 1, 0).displayName("§cSchwert 1").lore("§8» §7Kosten: §e10 Coins").enchantment(Enchantment.DAMAGE_ALL, 1).create(), 10),
    sword2(new ItemBuilder(Material.DIAMOND_SWORD, 1, 0).displayName("§cSchwert 2").lore("§8» §7Kosten: §e15 Coins").enchantment(Enchantment.DAMAGE_ALL, 2).create(), 15),
    sword3(new ItemBuilder(Material.DIAMOND_SWORD, 1, 0).displayName("§cSchwert 3").lore("§8» §7Kosten: §e20 Coins").enchantment(Enchantment.DAMAGE_ALL, 3).enchantment(Enchantment.DURABILITY, 1).enchantment(Enchantment.FIRE_ASPECT, 1).create(), 20),
    sword4(new ItemBuilder(Material.DIAMOND_SWORD, 1, 0).displayName("§cSchwert 4").lore("§8» §7Kosten: §e50 Coins").enchantment(Enchantment.DAMAGE_ALL, 4).enchantment(Enchantment.DURABILITY, 2).enchantment(Enchantment.FIRE_ASPECT, 2).create(), 50),
    sword5(new ItemBuilder(Material.DIAMOND_SWORD, 1, 0).displayName("§cSchwert 4").lore("§8» §7Kosten: §e100 Coins").enchantment(Enchantment.DAMAGE_ALL, 5).enchantment(Enchantment.DURABILITY, 3).enchantment(Enchantment.FIRE_ASPECT, 3).create(), 100),

    bow1(new ItemBuilder(Material.BOW, 1, 0).displayName("§cBogen 1").lore("§8» §7Kosten: §e10 Coins").enchantment(Enchantment.ARROW_DAMAGE, 1).create(), 10),
    bow2(new ItemBuilder(Material.BOW, 1, 0).displayName("§cBogen 2").lore("§8» §7Kosten: §e15 Coins").enchantment(Enchantment.ARROW_DAMAGE, 2).create(), 15),
    bow3(new ItemBuilder(Material.BOW, 1, 0).displayName("§cBogen 3").lore("§8» §7Kosten: §e25 Coins").enchantment(Enchantment.ARROW_DAMAGE, 3).enchantment(Enchantment.ARROW_FIRE, 1).enchantment(Enchantment.ARROW_KNOCKBACK, 1).enchantment(Enchantment.DURABILITY, 1).create(), 25),
    bow4(new ItemBuilder(Material.BOW, 1, 0).displayName("§cBogen 4").lore("§8» §7Kosten: §e50 Coins").enchantment(Enchantment.ARROW_DAMAGE, 4).enchantment(Enchantment.ARROW_FIRE, 1).enchantment(Enchantment.ARROW_KNOCKBACK, 2).enchantment(Enchantment.DURABILITY, 2).create(), 50),
    bow5(new ItemBuilder(Material.BOW, 1, 0).displayName("§cBogen 5").lore("§8» §7Kosten: §e100 Coins").enchantment(Enchantment.ARROW_DAMAGE, 5).enchantment(Enchantment.ARROW_FIRE, 1).enchantment(Enchantment.ARROW_KNOCKBACK, 2).enchantment(Enchantment.DURABILITY, 3).enchantment(Enchantment.ARROW_INFINITE, 1).create(), 100),

    helm1(new ItemBuilder(Material.DIAMOND_HELMET, 1, 0).displayName("§cHelm 1").lore("§8» §7Kosten: §e10 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).create(), 10),
    helm2(new ItemBuilder(Material.DIAMOND_HELMET, 1, 0).displayName("§cHelm 2").lore("§8» §7Kosten: §e25 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).create(), 25),
    helm3(new ItemBuilder(Material.DIAMOND_HELMET, 1, 0).displayName("§cHelm 3").lore("§8» §7Kosten: §e50 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).create(), 50),
    helm4(new ItemBuilder(Material.DIAMOND_HELMET, 1, 0).displayName("§cHelm 4").lore("§8» §7Kosten: §e100 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).create(), 100),

    chest1(new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).displayName("§cBrust 1").lore("§8» §7Kosten: §e10 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).create(), 10),
    chest2(new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).displayName("§cBrust 2").lore("§8» §7Kosten: §e25 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).create(), 25),
    chest3(new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).displayName("§cBrust 3").lore("§8» §7Kosten: §e50 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).create(), 50),
    chest4(new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).displayName("§cBrust 4").lore("§8» §7Kosten: §e100 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).create(), 100),

    leggin1(new ItemBuilder(Material.DIAMOND_LEGGINGS, 1, 0).displayName("§cHose 1").lore("§8» §7Kosten: §e10 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).create(), 10),
    leggin2(new ItemBuilder(Material.DIAMOND_LEGGINGS, 1, 0).displayName("§cHose 2").lore("§8» §7Kosten: §e25 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).create(), 25),
    leggin3(new ItemBuilder(Material.DIAMOND_LEGGINGS, 1, 0).displayName("§cHose 3").lore("§8» §7Kosten: §e50 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).create(), 50),
    leggin4(new ItemBuilder(Material.DIAMOND_LEGGINGS, 1, 0).displayName("§cHose 4").lore("§8» §7Kosten: §e100 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).create(), 100),

    shoe1(new ItemBuilder(Material.DIAMOND_BOOTS, 1, 0).displayName("§cSchuhe 1").lore("§8» §7Kosten: §e10 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).create(), 10),
    shoe2(new ItemBuilder(Material.DIAMOND_BOOTS, 1, 0).displayName("§cSchuhe 2").lore("§8» §7Kosten: §e25 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).create(), 25),
    shoe3(new ItemBuilder(Material.DIAMOND_BOOTS, 1, 0).displayName("§cSchuhe 3").lore("§8» §7Kosten: §e50 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).create(), 50),
    shoe4(new ItemBuilder(Material.DIAMOND_BOOTS, 1, 0).displayName("§cSchuhe 4").lore("§8» §7Kosten: §e100 Coins").enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).create(), 100),

    op1(new ItemBuilder(Material.GOLDEN_APPLE, 10, 0).displayName("§c10 OP-Äpfel").lore("§8» §7Kosten: §e50 Coins").create(), 50),
    op2(new ItemBuilder(Material.GOLDEN_APPLE, 15, 0).displayName("§c15 OP-Äpfel").lore("§8» §7Kosten: §e75 Coins").create(), 75),
    op3(new ItemBuilder(Material.GOLDEN_APPLE, 20, 0).displayName("§c20 OP-Äpfel").lore("§8» §7Kosten: §e100 Coins").create(), 100),
    op4(new ItemBuilder(Material.GOLDEN_APPLE, 25, 0).displayName("§c25 OP-Äpfel").lore("§8» §7Kosten: §e125 Coins").create(), 125),
    op5(new ItemBuilder(Material.GOLDEN_APPLE, 30, 0).displayName("§c30 OP-Äpfel").lore("§8» §7Kosten: §e150 Coins").create(), 150),

    axe1(new ItemBuilder(Material.DIAMOND_AXE, 1, 0).displayName("§cAxt 1").lore("§8» §7Kosten: §e50 Coins").enchantment(Enchantment.DAMAGE_ALL, 5).create(), 50),
    axe2(new ItemBuilder(Material.DIAMOND_AXE, 1, 0).displayName("§cAxt 2").lore("§8» §7Kosten: §e100 Coins").enchantment(Enchantment.DAMAGE_ALL, 5).enchantment(Enchantment.FIRE_ASPECT, 2).create(), 100),
    soup(new ItemBuilder(Material.MUSHROOM_SOUP, 1, 0).displayName("§cAxt 2").lore("§8» §7Kosten: §e250 Coins", "§7mit dieser Suppe kannst du dich heilen!").create(), 250);

    private int coins;
    private ItemStack item;

    ShopItem(ItemStack item, int coins) {
        this.coins = coins;
        this.item = item;
    }

    public ItemStack getItem() {
        return item;
    }

    public int getCoins() {
        return coins;
    }
}
