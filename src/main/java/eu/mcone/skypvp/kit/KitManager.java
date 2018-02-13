/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.kit;

import eu.mcone.coresystem.bukkit.api.CoinsAPI;
import eu.mcone.coresystem.bukkit.util.ItemFactory;
import eu.mcone.coresystem.lib.mysql.MySQL;
import eu.mcone.skypvp.SkyPvP;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.util.*;

public class KitManager {

    private MySQL mysql;
    private HashMap<UUID, ArrayList<Kit>> kits;
    private HashMap<UUID, ArrayList<Kit>> buyedKits;

    private BukkitRunnable asyncRunnable;

    public KitManager(MySQL mysql) {
        this.mysql = mysql;

        kits = new HashMap<>();
        buyedKits = new HashMap<>();

        asyncRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                mysql.select("SELECT * FROM skypvp_kits", rs -> {
                    buyedKits.clear();

                    try {
                        while (rs.next()) {
                            UUID uuid = UUID.fromString(rs.getString("uuid"));
                            ArrayList<Kit> kits = buyedKits.getOrDefault(uuid, new ArrayList<>());

                            kits.add(Kit.getKitByID(rs.getInt("kit")));
                            buyedKits.put(uuid, kits);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            }
        };
        asyncRunnable.runTaskTimerAsynchronously(SkyPvP.getInstance(), 100L, 100L);
    }

    public void setKit(Player p, Kit kit) {
        if (!hasKit(p, kit)){
            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du besitzt dieses Kit nicht!");
        } else if (kits.containsKey(p.getUniqueId()) && kits.get(p.getUniqueId()).contains(kit)) {
            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du hast dieses Kit bereits ausgewählt! Du kannst es erst wieder benutzen, nachdem du einmal gestorben bist!");
        } else {
            if (kit.equals(Kit.PLAYER)) {
                p.getInventory().setItem(0, ItemFactory.createEnchantedItem(Material.STONE_SWORD, new HashMap<Enchantment, Integer>() {{
                    put(Enchantment.DAMAGE_ALL, 1);
                    put(Enchantment.DURABILITY, 1);
                }}, 0, 1, "", false));
                p.getInventory().setItem(1, ItemFactory.createEnchantedItem(Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {{
                    put(Enchantment.DURABILITY, 1);
                }}, 0, 1, "", false));
                p.getInventory().setItem(2, ItemFactory.createItem(Material.COOKED_CHICKEN, 0, 20, "", false));
                p.getInventory().setItem(7, ItemFactory.createItem(Material.GOLDEN_APPLE, 0, 1, "", false));
                p.getInventory().setItem(8, ItemFactory.createItem(Material.ENDER_PEARL, 0, 16, "", false));

                p.getInventory().setHelmet(ItemFactory.createEnchantedItem(Material.CHAINMAIL_HELMET, new HashMap<Enchantment, Integer>() {{
                    put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    put(Enchantment.DURABILITY, 1);
                }}, 0, 1, "", false));
                p.getInventory().setChestplate(ItemFactory.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, new HashMap<Enchantment, Integer>() {{
                    put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    put(Enchantment.DURABILITY, 1);
                }}, 0, 1, "", false));
                p.getInventory().setLeggings(ItemFactory.createEnchantedItem(Material.CHAINMAIL_LEGGINGS, new HashMap<Enchantment, Integer>() {{
                    put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    put(Enchantment.DURABILITY, 1);
                }}, 0, 1, "", false));
                p.getInventory().setBoots(ItemFactory.createEnchantedItem(Material.CHAINMAIL_BOOTS, new HashMap<Enchantment, Integer>() {{
                    put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    put(Enchantment.DURABILITY, 1);
                }}, 0, 1, "", false));
            } else if (kit.equals(Kit.IRON)) {
                if (hasKit(p, Kit.IRON)) {
                    p.getInventory().setItem(0, ItemFactory.createEnchantedItem(Material.IRON_SWORD, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.DAMAGE_ALL, 1);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setItem(1, ItemFactory.createEnchantedItem(Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setItem(2, ItemFactory.createItem(Material.COOKED_CHICKEN, 0, 20, "", false));
                    p.getInventory().setItem(7, ItemFactory.createItem(Material.GOLDEN_APPLE, 0, 5, "", false));
                    p.getInventory().setItem(8, ItemFactory.createItem(Material.ENDER_PEARL, 0, 16, "", false));

                    p.getInventory().setHelmet(ItemFactory.createEnchantedItem(Material.IRON_HELMET, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setChestplate(ItemFactory.createEnchantedItem(Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setLeggings(ItemFactory.createEnchantedItem(Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setBoots(ItemFactory.createEnchantedItem(Material.IRON_BOOTS, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                } else {
                    p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du besitzt das §cEisen-Kit §4nicht");
                    return;
                }
            } else if (kit.equals(Kit.DIAMOND)) {
                if (hasKit(p, Kit.DIAMOND)) {
                    p.getInventory().setItem(0, ItemFactory.createEnchantedItem(Material.IRON_SWORD, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.DAMAGE_ALL, 2);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setItem(1, ItemFactory.createEnchantedItem(Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.DAMAGE_ALL, 1);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setItem(2, ItemFactory.createItem(Material.COOKED_CHICKEN, 0, 20, "", false));
                    p.getInventory().setItem(7, ItemFactory.createItem(Material.GOLDEN_APPLE, 0, 8, "", false));
                    p.getInventory().setItem(8, ItemFactory.createItem(Material.ENDER_PEARL, 0, 16, "", false));

                    p.getInventory().setHelmet(ItemFactory.createEnchantedItem(Material.IRON_HELMET, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setChestplate(ItemFactory.createEnchantedItem(Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setLeggings(ItemFactory.createEnchantedItem(Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setBoots(ItemFactory.createEnchantedItem(Material.IRON_BOOTS, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                } else {
                    p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du besitzt das §cDiamond-Kit §4nicht");
                    return;
                }
            } else if (kit.equals(Kit.EMERALD)) {
                if (hasKit(p, Kit.EMERALD)) {
                    p.getInventory().setItem(0, ItemFactory.createEnchantedItem(Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.DAMAGE_ALL, 1);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setItem(1, ItemFactory.createEnchantedItem(Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setItem(2, ItemFactory.createItem(Material.COOKED_CHICKEN, 0, 20, "", false));
                    p.getInventory().setItem(7, ItemFactory.createItem(Material.GOLDEN_APPLE, 0, 15, "", false));
                    p.getInventory().setItem(8, ItemFactory.createItem(Material.ENDER_PEARL, 0, 16, "", false));

                    p.getInventory().setHelmet(ItemFactory.createEnchantedItem(Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setChestplate(ItemFactory.createEnchantedItem(Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setLeggings(ItemFactory.createEnchantedItem(Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                    p.getInventory().setBoots(ItemFactory.createEnchantedItem(Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>() {{
                        put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        put(Enchantment.DURABILITY, 1);
                    }}, 0, 1, "", false));
                } else {
                    p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du besitzt das §cEmerald-Kit §4nicht");
                    return;
                }
            }

            if (kits.containsKey(p.getUniqueId())) {
                kits.get(p.getUniqueId()).add(kit);
            } else {
                kits.put(p.getUniqueId(), new ArrayList<>(Collections.singletonList(kit)));
            }

            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
            p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§2Du hast das Kit " + kit.getName() + " §2erhalten");
        }
    }

    public void setInvItem(Inventory inv, Player p, Kit kit, int i) {
        if (hasKit(p, kit)) {
            inv.setItem(i, ItemFactory.createItem(kit.getItem(), 0, 1, kit.getName(), new ArrayList<>(Arrays.asList("§r", "§2§oDu besitzt dieses Item!", "§8» §f§nRechtsklick§8 | §7§oAktivieren")), true));
        } else {
            inv.setItem(i, ItemFactory.createItem(kit.getItem(), 0, 1, kit.getName(), new ArrayList<>(Arrays.asList("§r", "§c§oDu besitzt dieses Item nicht!", "§7§oKostet: §f§o" + kit.getCoins() + " Coins")), true));
        }
    }

    public void createMySQLTable() {
        this.mysql.update("CREATE TABLE IF NOT EXISTS skypvp_kits (`id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, `uuid` VARCHAR(100), `kit` VARCHAR(100) NOT NULL, `timestamp` int(50)) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
    }

    public void buyAndSet(Player p, Kit kit) {
        if ((kits.containsKey(p.getUniqueId()) && kits.get(p.getUniqueId()).contains(kit)) || hasKit(p, kit)) {
            p.sendMessage("§4Du besitzt dieses Kit bereits!");
        } else {
            if ((CoinsAPI.getCoins(p.getUniqueId()) - kit.getCoins()) >= 0) {
                CoinsAPI.removeCoins(p.getUniqueId(), kit.getCoins());
                mysql.update("INSERT IGNORE INTO `skypvp_kits` (`id`, `uuid`, `kit`, `timestamp`) VALUES (NULL, '" + p.getUniqueId() + "', '" + kit.getID() + "', " + (System.currentTimeMillis() / 1000L) + ");");
                buyedKits.getOrDefault(p, new ArrayList<>()).add(kit);

                setKit(p, kit);
                p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§2Du hast erfolgreich das Kit " + kit.getName() + "§2 gekauft!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
            } else {
                p.sendMessage(SkyPvP.config.getConfigValue("System-Prefix") + "§4Du hast nicht genügend Coins!");
                p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
            }
        }
    }

    public boolean hasKit(Player p, Kit kit) {
        return buyedKits.getOrDefault(p.getUniqueId(), new ArrayList<>()).contains(kit) || p.hasPermission(kit.getPermission());
    }

    public void resetKits(Player p) {
        if (kits.containsKey(p.getUniqueId())) kits.remove(p.getUniqueId());
    }

    public BukkitRunnable getAsyncRunnable() {
        return asyncRunnable;
    }
}
