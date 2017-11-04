package de.Dominik.SkyPvP.inventory;

import de.Dominik.BukkitCoreSystem.util.ItemManager;
import de.Dominik.SkyPvP.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class KitInventory {

    public KitInventory(Player p) {
        Inventory inv = Bukkit.getServer().createInventory(null, 27, "§8Wähle dein Kit");

        for (int i = 0; i <= 26; i++) {
            inv.setItem(i, ItemManager.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
        }

        inv.setItem(10, ItemManager.createItem(Material.STONE_SWORD, 0, 1, "§7Kit §8Spieler", true));
        inv.setItem(12, ItemManager.createItem(Material.DIAMOND_SWORD, 0, 1, "§7Kit §3Diamond", true));
        inv.setItem(14, ItemManager.createItem(Material.EMERALD, 0, 1, "§7Kit §2Emerald", true));
        inv.setItem(16, ItemManager.createItem(Material.IRON_INGOT, 0, 1, "§7Kit §dPlatin", true));

        p.openInventory(inv);
    }

    public static void click(InventoryClickEvent e, Player p) {
        if (e.getCurrentItem().getType() == Material.STONE_SWORD){
            p.getInventory().setItem(0, ItemManager.createEnchantedItem(Material.STONE_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
            p.getInventory().setItem(1, ItemManager.createEnchantedItem(Material.FISHING_ROD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
            p.getInventory().setItem(2, ItemManager.createItem(Material.COOKED_CHICKEN, 0, 20, "", false));
            p.getInventory().setItem(7, ItemManager.createItem(Material.GOLDEN_APPLE, 0, 1, "", false));
            p.getInventory().setItem(8, ItemManager.createItem(Material.ENDER_PEARL, 0, 16, "", false));

            p.getInventory().setHelmet(ItemManager.createEnchantedItem(Material.CHAINMAIL_HELMET, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
            p.getInventory().setChestplate(ItemManager.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
            p.getInventory().setLeggings(ItemManager.createEnchantedItem(Material.CHAINMAIL_LEGGINGS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
            p.getInventory().setBoots(ItemManager.createEnchantedItem(Material.CHAINMAIL_BOOTS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));

            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§aDu hast das Kit §8Spieler §aausgewählt");
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
            p.closeInventory();
        }else if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD){

            if (p.hasPermission("skypvp.kit.diamond") || p.hasPermission("skypvp.*") || p.hasPermission("system.*")){
                p.getInventory().setItem(0, ItemManager.createEnchantedItem(Material.IRON_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setItem(1, ItemManager.createEnchantedItem(Material.FISHING_ROD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setItem(2, ItemManager.createItem(Material.COOKED_CHICKEN, 0, 20, "", false));
                p.getInventory().setItem(7, ItemManager.createItem(Material.GOLDEN_APPLE, 0, 5, "", false));
                p.getInventory().setItem(8, ItemManager.createItem(Material.ENDER_PEARL, 0, 16, "", false));

                p.getInventory().setHelmet(ItemManager.createEnchantedItem(Material.IRON_HELMET, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setChestplate(ItemManager.createEnchantedItem(Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setLeggings(ItemManager.createEnchantedItem(Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setBoots(ItemManager.createEnchantedItem(Material.IRON_BOOTS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));

                p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§aDu hast das Kit §3Diamond §aausgewählt");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                p.closeInventory();
            } else {
                p.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-No-Perm"));
            }
        } else if (e.getCurrentItem().getType() == Material.EMERALD) {
            if (p.hasPermission("skypvp.kit.emerald")|| p.hasPermission("skypvp.*") || p.hasPermission("system.*")) {
                p.getInventory().setItem(0, ItemManager.createEnchantedItem(Material.IRON_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 2); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setItem(1, ItemManager.createEnchantedItem(Material.FISHING_ROD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setItem(2, ItemManager.createItem(Material.COOKED_CHICKEN, 0, 20, "", false));
                p.getInventory().setItem(7, ItemManager.createItem(Material.GOLDEN_APPLE, 0, 8, "", false));
                p.getInventory().setItem(8, ItemManager.createItem(Material.ENDER_PEARL, 0, 16, "", false));

                p.getInventory().setHelmet(ItemManager.createEnchantedItem(Material.IRON_HELMET, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setChestplate(ItemManager.createEnchantedItem(Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setLeggings(ItemManager.createEnchantedItem(Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setBoots(ItemManager.createEnchantedItem(Material.IRON_BOOTS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));

                p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§aDu hast das Kit §2Emerald §aausgewählt");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                p.closeInventory();
            }else{
                p.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-No-Perm"));
            }
        }else if (e.getCurrentItem().getType() == Material.IRON_INGOT){
            if (p.hasPermission("skypvp.kit.platin") || p.hasPermission("skypvp.*") || p.hasPermission("System.*")){
                p.getInventory().setItem(0, ItemManager.createEnchantedItem(Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setItem(1, ItemManager.createEnchantedItem(Material.FISHING_ROD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setItem(2, ItemManager.createItem(Material.COOKED_CHICKEN, 0, 20, "", false));
                p.getInventory().setItem(7, ItemManager.createItem(Material.GOLDEN_APPLE, 0, 15, "", false));
                p.getInventory().setItem(8, ItemManager.createItem(Material.ENDER_PEARL, 0, 16, "", false));

                p.getInventory().setHelmet(ItemManager.createEnchantedItem(Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setChestplate(ItemManager.createEnchantedItem(Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setLeggings(ItemManager.createEnchantedItem(Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
                p.getInventory().setBoots(ItemManager.createEnchantedItem(Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 3); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));

                p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§aDu hast das Kit §dPlatin §aausgewählt");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                p.closeInventory();
            } else {
                p.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-No-Perm"));
            }
        }
    }

}
