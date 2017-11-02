package de.Dominik.SkyPvP.event;

import de.Dominik.BukkitCoreSystem.util.LocationFactory;
import de.Dominik.SkyPvP.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerRespawn_Event implements Listener{

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        p.getInventory().clear();
        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§eDu hast das §6Standart §eKit bekommen!");
        /**
         p.getInventory().setItem(0, Listener_LISTENER.build(Material.WOOD_SWORD, 1, 0, "§7Holz-Schwert", "§7K§mpfe damit!"));
         p.getInventory().setItem(8, Listener_LISTENER.build(Material.GOLDEN_APPLE, 1, 0, "§eGoldener-Apfel", "§eDu braucht Extra Herzen?"));
         p.getInventory().setChestplate(Listener_LISTENER.build(Material.LEATHER_CHESTPLATE, 1, 0, "§7Leather-ChestPlate", " "));
         p.getInventory().setHelmet(Listener_LISTENER.build(Material.LEATHER_HELMET, 1, 0, "§7Leather-Helm", " "));
         p.getInventory().setBoots(Listener_LISTENER.build(Material.LEATHER_BOOTS, 1, 0, "§7Leather-Boots", " "));
         p.getInventory().setLeggings(Listener_LISTENER.build(Material.LEATHER_LEGGINGS, 1, 0, "§7Leather-Hose", " "));
         p.getInventory().setItem(1, Listener_LISTENER.build(Material.COOKED_BEEF, 16, 0, "§6Essen", "§7Iss etwas!"));
         */

        ItemStack ss = new ItemStack(Material.STONE_SWORD);
        ItemMeta im = ss.getItemMeta();
        im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        im.addEnchant(Enchantment.DURABILITY, 1, true);
        ss.setItemMeta(im);
        p.getInventory().setItem(0, ss);

        ItemStack angel = new ItemStack(Material.FISHING_ROD);
        ItemMeta im1 = angel.getItemMeta();
        im1.addEnchant(Enchantment.DURABILITY, 1, true);
        angel.setItemMeta(im1);
        p.getInventory().setItem(1, angel);

        ItemStack food = new ItemStack(Material.COOKED_CHICKEN, 20);
        p.getInventory().setItem(2, food);

        ItemStack ga = new ItemStack(Material.GOLDEN_APPLE, 1);
        p.getInventory().setItem(7, ga);

        ItemStack ep = new ItemStack(Material.ENDER_PEARL, 16);
        p.getInventory().setItem(8, ep);

        ItemStack ch = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta im2 = ch.getItemMeta();
        im2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        im2.addEnchant(Enchantment.DURABILITY, 1, true);
        ch.setItemMeta(im2);
        p.getInventory().setHelmet(ch);

        ItemStack cc = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta im3 = cc.getItemMeta();
        im3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        im3.addEnchant(Enchantment.DURABILITY, 1, true);
        cc.setItemMeta(im3);
        p.getInventory().setChestplate(cc);

        ItemStack cl = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta im4 = cl.getItemMeta();
        im4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        im4.addEnchant(Enchantment.DURABILITY, 1, true);
        cl.setItemMeta(im4);
        p.getInventory().setLeggings(cl);

        ItemStack cb = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta im5 = cb.getItemMeta();
        im5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        im5.addEnchant(Enchantment.DURABILITY, 1, true);
        cb.setItemMeta(im5);
        p.getInventory().setBoots(cb);

        e.setRespawnLocation(LocationFactory.getConfigLocation(Main.config, "Location-Spawn"));
    }

}
