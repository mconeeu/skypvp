/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.kit;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import eu.mcone.coresystem.api.core.mysql.MySQL;
import eu.mcone.skypvp.SkyPvP;
import eu.mcone.skypvp.inventory.KitBuyInventory;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

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
            p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§4Du besitzt dieses Kit nicht!");
        } else if (kits.containsKey(p.getUniqueId()) && kits.get(p.getUniqueId()).contains(kit)) {
            p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§4Du hast dieses Kit bereits ausgewählt! Du kannst es erst wieder benutzen, nachdem du einmal gestorben bist!");
        } else {
            if (kit.equals(Kit.PLAYER)) {
                p.getInventory().setItem(0, new ItemBuilder(Material.STONE_SWORD, 1, 0).create());
                p.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, 0).create());
                p.getInventory().setItem(2, new ItemBuilder(Material.COOKED_CHICKEN, 20, 0).create());
                p.getInventory().setItem(7, new ItemBuilder(Material.GOLDEN_APPLE, 1, 0).create());
                p.getInventory().setItem(8, new ItemBuilder(Material.ENDER_PEARL, 16, 0).create());

                p.getInventory().setHelmet(new ItemBuilder(Material.CHAINMAIL_HELMET, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                p.getInventory().setChestplate(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                p.getInventory().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                p.getInventory().setBoots(new ItemBuilder(Material.CHAINMAIL_BOOTS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.DURABILITY, 1).create());
            } else if (kit.equals(Kit.IRON)) {
                if (hasKit(p, Kit.IRON)) {
                    p.getInventory().setItem(0, new ItemBuilder(Material.IRON_SWORD, 1, 0).enchantment(Enchantment.DAMAGE_ALL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, 0).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setItem(2, new ItemBuilder(Material.COOKED_CHICKEN, 20, 0).create());
                    p.getInventory().setItem(7, new ItemBuilder(Material.GOLDEN_APPLE, 5, 0).create());
                    p.getInventory().setItem(8, new ItemBuilder(Material.ENDER_PEARL, 16, 0).create());

                    p.getInventory().setHelmet(new ItemBuilder(Material.IRON_HELMET, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setChestplate(new ItemBuilder(Material.IRON_CHESTPLATE, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setLeggings(new ItemBuilder(Material.IRON_LEGGINGS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setBoots(new ItemBuilder(Material.IRON_BOOTS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                } else {
                    p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§4Du besitzt das §cEisen-Kit §4nicht");
                    return;
                }
            } else if (kit.equals(Kit.DIAMOND)) {
                if (hasKit(p, Kit.DIAMOND)) {
                    p.getInventory().setItem(0, new ItemBuilder(Material.IRON_SWORD, 1, 0).enchantment(Enchantment.DAMAGE_ALL, 2).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, 0).enchantment(Enchantment.DAMAGE_ALL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setItem(2, new ItemBuilder(Material.COOKED_CHICKEN, 20, 0).create());
                    p.getInventory().setItem(7, new ItemBuilder(Material.GOLDEN_APPLE, 8, 0).create());
                    p.getInventory().setItem(8, new ItemBuilder(Material.ENDER_PEARL, 16, 0).create());

                    p.getInventory().setHelmet(new ItemBuilder(Material.IRON_HELMET, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setChestplate(new ItemBuilder(Material.IRON_CHESTPLATE, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setLeggings(new ItemBuilder(Material.IRON_LEGGINGS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setBoots(new ItemBuilder(Material.IRON_BOOTS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 1).create());
                } else {
                    p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§4Du besitzt das §cDiamond-Kit §4nicht");
                    return;
                }
            } else if (kit.equals(Kit.EMERALD)) {
                if (hasKit(p, Kit.EMERALD)) {
                    p.getInventory().setItem(0, new ItemBuilder(Material.DIAMOND_SWORD, 1, 0).enchantment(Enchantment.DAMAGE_ALL, 1).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, 0).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setItem(2, new ItemBuilder(Material.COOKED_CHICKEN, 20, 0).create());
                    p.getInventory().setItem(7, new ItemBuilder(Material.GOLDEN_APPLE, 15, 0).create());
                    p.getInventory().setItem(8, new ItemBuilder(Material.ENDER_PEARL, 16, 0).create());

                    p.getInventory().setHelmet(new ItemBuilder(Material.DIAMOND_HELMET, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setLeggings(new ItemBuilder(Material.DIAMOND_LEGGINGS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 1).create());
                    p.getInventory().setBoots(new ItemBuilder(Material.DIAMOND_BOOTS, 1, 0).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 1).create());
                } else {
                    p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§4Du besitzt das §cEmerald-Kit §4nicht");
                    return;
                }
            }

            if (kits.containsKey(p.getUniqueId())) {
                kits.get(p.getUniqueId()).add(kit);
            } else {
                kits.put(p.getUniqueId(), new ArrayList<>(Collections.singletonList(kit)));
            }

            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
            p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§2Du hast das Kit " + kit.getName() + " §2erhalten");
        }
    }

    public void setInvItem(CoreInventory inv, Player p, Kit kit, int i) {
        if (hasKit(p, kit)) {
            inv.setItem(i, new ItemBuilder(kit.getItem(), 1, 0).displayName(kit.getName()).lore("§r", "§2§oDu besitzt dieses Item!", "§8» §f§nRechtsklick§8 | §7§oAktivieren").create(), () -> {
                SkyPvP.getInstance().getKitManager().setKit(p, kit);
                p.closeInventory();
            });
        } else {
            inv.setItem(i, new ItemBuilder(kit.getItem(), 1, 0).displayName(kit.getName()).lore("§r", "§c§oDu besitzt dieses Item nicht!", "§7§oKostet: §f§o" + kit.getCoins() + " Coins").create(), () -> {
                new KitBuyInventory(p, kit);
            });
        }
    }

    public void createMySQLTable() {
        this.mysql.update("CREATE TABLE IF NOT EXISTS skypvp_kits (`id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, `uuid` VARCHAR(100), `kit` VARCHAR(100) NOT NULL, `timestamp` int(50)) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
    }

    public void buyAndSet(Player p, Kit kit) {
        if ((kits.containsKey(p.getUniqueId()) && kits.get(p.getUniqueId()).contains(kit)) || hasKit(p, kit)) {
            p.sendMessage("§4Du besitzt dieses Kit bereits!");
        } else {
            if ((CoreSystem.getInstance().getCoinsAPI().getCoins(p.getUniqueId()) - kit.getCoins()) >= 0) {
                CoreSystem.getInstance().getCoinsAPI().removeCoins(p.getUniqueId(), kit.getCoins());
                mysql.update("INSERT IGNORE INTO `skypvp_kits` (`id`, `uuid`, `kit`, `timestamp`) VALUES (NULL, '" + p.getUniqueId() + "', '" + kit.getID() + "', " + (System.currentTimeMillis() / 1000L) + ");");
                buyedKits.getOrDefault(p, new ArrayList<>()).add(kit);

                setKit(p, kit);
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§2Du hast erfolgreich das Kit " + kit.getName() + "§2 gekauft!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
            } else {
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§4Du hast nicht genügend Coins!");
                p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
            }
        }
    }

    private boolean hasKit(Player p, Kit kit) {
        return buyedKits.getOrDefault(p.getUniqueId(), new ArrayList<>()).contains(kit) || p.hasPermission(kit.getPermission());
    }

    public void resetKits(Player p) {
        kits.remove(p.getUniqueId());
    }

    public BukkitRunnable getAsyncRunnable() {
        return asyncRunnable;
    }
}
