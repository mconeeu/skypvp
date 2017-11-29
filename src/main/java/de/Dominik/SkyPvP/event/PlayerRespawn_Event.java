/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.event;

import de.Dominik.BukkitCoreSystem.util.ItemManager;
import de.Dominik.BukkitCoreSystem.util.LocationFactory;
import de.Dominik.SkyPvP.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.HashMap;

public class PlayerRespawn_Event implements Listener{

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        p.getInventory().clear();

        p.getInventory().setItem(0, ItemManager.createEnchantedItem(Material.STONE_SWORD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DAMAGE_ALL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
        p.getInventory().setItem(1, ItemManager.createEnchantedItem(Material.FISHING_ROD, new HashMap<Enchantment, Integer>(){{put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
        p.getInventory().setItem(2, ItemManager.createItem(Material.COOKED_CHICKEN, 0, 20, "", false));
        p.getInventory().setItem(7, ItemManager.createItem(Material.GOLDEN_APPLE, 0, 1, "", false));
        p.getInventory().setItem(8, ItemManager.createItem(Material.ENDER_PEARL, 0, 16, "", false));

        p.getInventory().setHelmet(ItemManager.createEnchantedItem(Material.CHAINMAIL_HELMET, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
        p.getInventory().setChestplate(ItemManager.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
        p.getInventory().setLeggings(ItemManager.createEnchantedItem(Material.CHAINMAIL_LEGGINGS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));
        p.getInventory().setBoots(ItemManager.createEnchantedItem(Material.CHAINMAIL_BOOTS, new HashMap<Enchantment, Integer>(){{put(Enchantment.PROTECTION_ENVIRONMENTAL, 1); put(Enchantment.DURABILITY, 1);}}, 0, 1, "", false));

        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§2Du hast das §aStandart §2Kit bekommen!");


        Location respawnLocation = LocationFactory.getConfigLocation(Main.config, "Location-Spawn");

        if (respawnLocation != null) {
            e.setRespawnLocation(respawnLocation);
        } else {
            p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§4Du konntest nicht zum Spawn teleportiert werden, da der Spawn nicht eingespeichert ist!");
        }
    }

}
