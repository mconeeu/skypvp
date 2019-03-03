/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.player;

import lombok.Getter;
import org.bukkit.Material;

public enum Kit {

    PLAYER(0, "§8Standart-Kit", null, 0, Material.STONE_SWORD),
    IRON(1, "§7Iron-Kit", "skypvp.kit.iron", 500, Material.IRON_SWORD),
    DIAMOND(2, "§bDiamond-Kit", "skypvp.kit.diamond", 1000, Material.DIAMOND_SWORD),
    EMERALD(3, "§aEmerald-Kit", "skypvp.kit.emerald", 10000, Material.EMERALD);

    @Getter
    private int id, coins;
    @Getter
    private String name, permission;
    @Getter
    private Material item;

    Kit(int id, String name, String permission, int coins, Material item) {
        this.id = id;
        this.name = name;
        this.permission = permission;
        this.coins = coins;
        this.item = item;
    }

    public static Kit getKitByID(int id) {
        for (Kit kit : Kit.values()) {
            if (kit.getId() == id) {
                return kit;
            }
        }
        return null;
    }

}
