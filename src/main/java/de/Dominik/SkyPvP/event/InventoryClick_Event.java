package de.Dominik.SkyPvP.event;

import de.Dominik.BukkitCoreSystem.api.CoinsAPI;
import de.Dominik.BukkitCoreSystem.api.TitleAPI;
import de.Dominik.BukkitCoreSystem.util.ItemManager;
import de.Dominik.SkyPvP.inventory.ShopItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.Dominik.SkyPvP.Main;

import java.util.HashMap;

public class InventoryClick_Event implements Listener {

	ItemStack sword = new ItemStack(Material.STONE_SWORD);
	ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE);
	ItemStack sword1 = new ItemStack(Material.DIAMOND_SWORD);
	  
	@EventHandler
	public void on(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();

        Inventory waffengui = Bukkit.createInventory(p, 27, "§e§lShop §8§ §cWaffen");
        Inventory boegengui = Bukkit.createInventory(p, 27, "§e§lShop §8§ §cBögen");
        Inventory ruestunggui = Bukkit.createInventory(p, 36, "§e§lShop §8§ §cRüstung");
        Inventory extragui = Bukkit.createInventory(p, 27, "§e§lShop §8§ §cExtras");
        Inventory spezialgui = Bukkit.createInventory(p, 27, "§e§lShop §8§ §cSpezial");

        if((e.getRawSlot() < e.getInventory().getSize()) && (e.getCurrentItem() != null) && (!e.getInventory().getTitle().contains("Free Items"))){
            e.setCancelled(true);

            try{
                if (e.getClickedInventory().getTitle().equalsIgnoreCase("§8Wähle dein Kit")){
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
                            p.closeInventory();
                        } else {
                          p.sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-No-Perm"));
                        }
                    }
                } else if (e.getInventory().getName().equalsIgnoreCase("§9SkyPvP §8» §cShop")) {
                    e.setCancelled(true);
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchwerter")) {
                        waffengui.setItem(9, ShopItem.schwert1.getItem());
                        waffengui.setItem(11, ShopItem.schwert2.getItem());
                        waffengui.setItem(13, ShopItem.schwert3.getItem());
                        waffengui.setItem(15, ShopItem.schwert4.getItem());
                        waffengui.setItem(17, ShopItem.schwert5.getItem());

                        p.openInventory(waffengui);
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBögen")) {
                        boegengui.setItem(9, ShopItem.bogen1.getItem());
                        boegengui.setItem(11, ShopItem.bogen2.getItem());
                        boegengui.setItem(13, ShopItem.bogen3.getItem());
                        boegengui.setItem(15, ShopItem.bogen4.getItem());
                        boegengui.setItem(17, ShopItem.bogen5.getItem());

                        p.openInventory(boegengui);
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRüstung")) {
                        ruestunggui.setItem(2, ShopItem.helm1.getItem());
                        ruestunggui.setItem(3, ShopItem.helm2.getItem());
                        ruestunggui.setItem(4, ShopItem.helm3.getItem());
                        ruestunggui.setItem(5, ShopItem.helm4.getItem());

                        ruestunggui.setItem(11, ShopItem.brust1.getItem());
                        ruestunggui.setItem(12, ShopItem.brust2.getItem());
                        ruestunggui.setItem(13, ShopItem.brust3.getItem());
                        ruestunggui.setItem(14, ShopItem.brust4.getItem());

                        ruestunggui.setItem(20, ShopItem.hose1.getItem());
                        ruestunggui.setItem(21, ShopItem.hose2.getItem());
                        ruestunggui.setItem(22, ShopItem.hose3.getItem());
                        ruestunggui.setItem(23, ShopItem.hose4.getItem());

                        ruestunggui.setItem(29, ShopItem.schuhe1.getItem());
                        ruestunggui.setItem(30, ShopItem.schuhe2.getItem());
                        ruestunggui.setItem(31, ShopItem.schuhe3.getItem());
                        ruestunggui.setItem(32, ShopItem.schuhe4.getItem());

                        p.openInventory(ruestunggui);
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cExtras")) {
                        extragui.setItem(9, ShopItem.op1.getItem());
                        extragui.setItem(11, ShopItem.op2.getItem());
                        extragui.setItem(13, ShopItem.op3.getItem());
                        extragui.setItem(15, ShopItem.op4.getItem());
                        extragui.setItem(17, ShopItem.op5.getItem());

                        p.openInventory(extragui);
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSpezial")) {
                        spezialgui.setItem(10, ShopItem.axt1.getItem());
                        spezialgui.setItem(13, ShopItem.soup.getItem());
                        spezialgui.setItem(16, ShopItem.axt2.getItem());

                        p.openInventory(spezialgui);
                    }
                } else if (
                        e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cWaffen") ||
                        e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cBögen") ||
                        e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cRüstung") ||
                        e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cExtras") ||
                        e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cSpezial")
                        ) {

                    for (ShopItem item : ShopItem.values()) {
                        if (e.getCurrentItem().equals(item.getItem())) {
                            buyShopItem(p, item);
                        }
                    }
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
	}

    private void buyShopItem(Player p, ShopItem item){
        int futCoins = CoinsAPI.getCoins(p) - item.getCoins();
        if (futCoins <= -1){
            p.closeInventory();
            TitleAPI.sendTitle(p, Main.config.getConfigValue("System-Prefix"), "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
        } else {
            CoinsAPI.removeCoins(p, item.getCoins());
            p.getInventory().addItem(ShopItem.schwert1.getItem());
            TitleAPI.sendTitle(p, Main.config.getConfigValue("System-Prefix"), "§7Du hast das Item §e" + item + " §7gekauft!", 25, 25, 25);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
        }
    }
}
