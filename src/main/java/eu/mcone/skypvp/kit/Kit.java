/*
 * Copyright (c) 2017 -2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.kit;

import org.bukkit.Material;

public enum Kit {
    PLAYER(0, "§8Standart-Kit", null, 0, Material.STONE_SWORD),
    IRON(1, "§7Iron-Kit", "skypvp.kit.iron", 500, Material.IRON_SWORD),
    DIAMOND(2, "§bDiamond-Kit", "skypvp.kit.diamond", 1000, Material.DIAMOND_SWORD),
    EMERALD(3, "§aEmerald-Kit", "skypvp.kit.emerald", 10000, Material.EMERALD);

    private int id, coins;
    private String name, permission;
    private Material item;

    Kit(int id, String name, String permission, int coins, Material item) {
        this.id = id;
        this.name = name;
        this.permission = permission;
        this.coins = coins;
        this.item = item;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }

    public int getCoins() {
        return coins;
    }

    public Material getItem() {
        return item;
    }

    public static Kit getKitByName(String name) {
        for (Kit kit : Kit.values()) {
            if (kit.getName().equals(name)) {
                return kit;
            }
        }
        return null;
    }

    public static Kit getKitByID(int id) {
        for (Kit kit : Kit.values()) {
            if (kit.getID() == id) {
                return kit;
            }
        }
        return null;
    }

}
