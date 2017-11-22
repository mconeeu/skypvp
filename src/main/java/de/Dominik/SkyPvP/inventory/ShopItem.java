/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.inventory;

import de.Dominik.BukkitCoreSystem.util.ItemManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public enum ShopItem {

    schwerter(ItemManager.createItem(Material.DIAMOND_SWORD, 0, 1, "§cSchwerter", new ArrayList<>(Collections.singletonList("§8» §7Abteil mit Schwertern.")), true), 0),
    boegen(ItemManager.createItem(Material.BOW, 0, 1, "§cBögen", new ArrayList<>(Collections.singletonList("§8» §7Abteil mit Bögen.")), true), 0),
    ruestung(ItemManager.createItem(Material.DIAMOND_CHESTPLATE, 0, 1, "§cRüstung", new ArrayList<>(Collections.singletonList("§8» §7Abteil mit Rüstung.")), true), 0),
    extras(ItemManager.createItem(Material.NETHER_STAR, 0, 1, "§cExtras", new ArrayList<>(Collections.singletonList("§8» §7Abteil mit Extras.")), true), 0),
    spezial(ItemManager.createItem(Material.TNT, 0, 1, "§cSpezial", new ArrayList<>(Collections.singletonList("§8» §7Abteil mit Spezial Items.")), true), 0),

    schwert1(ItemManager.createEnchantedItem(Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 1);}}, 0, 1, "§cSchwert 1", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e10 Coins")), false), 10),
    schwert2(ItemManager.createEnchantedItem(Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 2);}}, 0, 1, "§cSchwert 2", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e15 Coins")), false), 15),
    schwert3(ItemManager.createEnchantedItem(Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 3); put(Enchantment.DURABILITY, 1); put(Enchantment.FIRE_ASPECT, 1);}}, 0, 1, "§cSchwert 3", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e20 Coins")), false), 20),
    schwert4(ItemManager.createEnchantedItem(Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 4); put(Enchantment.DURABILITY, 2); put(Enchantment.FIRE_ASPECT, 2);}}, 0, 1, "§cSchwert 4", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e50 Coins")), false), 50),
    schwert5(ItemManager.createEnchantedItem(Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 5); put(Enchantment.DURABILITY, 3); put(Enchantment.FIRE_ASPECT, 2);}}, 0, 1, "§cSchwert 4", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e100 Coins")), false), 100),

    bogen1(ItemManager.createEnchantedItem(Material.BOW, new HashMap<Enchantment, Integer>(){{put(Enchantment.ARROW_DAMAGE, 1);}}, 0, 1, "§cBogen 1", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e10 Coins")), false), 10),
    bogen2(ItemManager.createEnchantedItem(Material.BOW, new HashMap<Enchantment, Integer>(){{put(Enchantment.ARROW_DAMAGE, 2);}}, 0, 1, "§cBogen 2", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e15 Coins")), false), 15),
    bogen3(ItemManager.createEnchantedItem(Material.BOW, new HashMap<Enchantment, Integer>(){{put(Enchantment.ARROW_DAMAGE, 3); put(Enchantment.ARROW_FIRE, 1); put(Enchantment.ARROW_KNOCKBACK, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "§cBogen 3", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e25 Coins")), false), 25),
    bogen4(ItemManager.createEnchantedItem(Material.BOW, new HashMap<Enchantment, Integer>(){{put(Enchantment.ARROW_DAMAGE, 4); put(Enchantment.ARROW_FIRE, 1); put(Enchantment.ARROW_KNOCKBACK, 1); put(Enchantment.DURABILITY, 2);}}, 0, 1, "§cBogen 4", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e50 Coins")), false), 50),
    bogen5(ItemManager.createEnchantedItem(Material.BOW, new HashMap<Enchantment, Integer>(){{put(Enchantment.ARROW_DAMAGE, 5); put(Enchantment.ARROW_FIRE, 1); put(Enchantment.ARROW_KNOCKBACK, 2); put(Enchantment.DURABILITY, 3); put(Enchantment.ARROW_INFINITE, 1);}}, 0, 1, "§cBogen 5", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e100 Coins")), false), 100),

    helm1(ItemManager.createEnchantedItem(Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);}}, 0, 1, "§cHelm 1", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e10 Coins")), false), 10),
    helm2(ItemManager.createEnchantedItem(Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);}}, 0, 1, "§cHelm 2", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e25 Coins")), false), 25),
    helm3(ItemManager.createEnchantedItem(Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);}}, 0, 1, "§cHelm 3", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e50 Coins")), false), 50),
    helm4(ItemManager.createEnchantedItem(Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 4);}}, 0, 1, "§cHelm 4", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e100 Coins")), false), 100),

    brust1(ItemManager.createEnchantedItem(Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);}}, 0, 1, "§cBrust 1", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e10 Coins")), false), 10),
    brust2(ItemManager.createEnchantedItem(Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);}}, 0, 1, "§cBrust 2", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e25 Coins")), false), 25),
    brust3(ItemManager.createEnchantedItem(Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);}}, 0, 1, "§cBrust 3", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e50 Coins")), false), 50),
    brust4(ItemManager.createEnchantedItem(Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 4);}}, 0, 1, "§cBrust 4", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e100 Coins")), false), 100),

    hose1(ItemManager.createEnchantedItem(Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);}}, 0, 1, "§cHose 1", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e10 Coins")), false), 10),
    hose2(ItemManager.createEnchantedItem(Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);}}, 0, 1, "§cHose 2", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e25 Coins")), false), 25),
    hose3(ItemManager.createEnchantedItem(Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);}}, 0, 1, "§cHose 3", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e50 Coins")), false), 50),
    hose4(ItemManager.createEnchantedItem(Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 4);}}, 0, 1, "§cHose 4", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e100 Coins")), false), 100),

    schuhe1(ItemManager.createEnchantedItem(Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);}}, 0, 1, "§cSchuhe 1", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e10 Coins")), false), 10),
    schuhe2(ItemManager.createEnchantedItem(Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);}}, 0, 1, "§cSchuhe 2", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e25 Coins")), false), 25),
    schuhe3(ItemManager.createEnchantedItem(Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);}}, 0, 1, "§cSchuhe 3", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e50 Coins")), false), 50),
    schuhe4(ItemManager.createEnchantedItem(Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 4);}}, 0, 1, "§cSchuhe 4", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e100 Coins")), false), 100),

    op1(ItemManager.createItem(Material.GOLDEN_APPLE, 0, 10, "§c10 OP-Äpfel", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e50 Coins")), false), 50),
    op2(ItemManager.createItem(Material.GOLDEN_APPLE, 0, 15, "§c15 OP-Äpfel", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e75 Coins")), false), 75),
    op3(ItemManager.createItem(Material.GOLDEN_APPLE, 0, 20, "§c20 OP-Äpfel", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e100 Coins")), false), 100),
    op4(ItemManager.createItem(Material.GOLDEN_APPLE, 0, 25, "§c25 OP-Äpfel", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e125 Coins")), false), 125),
    op5(ItemManager.createItem(Material.GOLDEN_APPLE, 0, 30, "§c30 OP-Äpfel", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e150 Coins")), false), 150),

    axt1(ItemManager.createEnchantedItem(Material.DIAMOND_AXE, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 5);}}, 0, 1, "§cAxt 1", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e50 Coins")), false), 50),
    axt2(ItemManager.createEnchantedItem(Material.DIAMOND_AXE, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 5); put(Enchantment.FIRE_ASPECT, 2);}}, 0, 1, "§cAxt 2", new ArrayList<>(Collections.singletonList("§8» §7Kosten: §e100 Coins")), false), 100),
    soup(ItemManager.createItem(Material.MUSHROOM_SOUP, 0, 1, "§cAxt 2", new ArrayList<>(Arrays.asList("§8» §7Kosten: §e250 Coins", "§7mit dieser Suppe kannst du dich heilen!")), false), 250);

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
