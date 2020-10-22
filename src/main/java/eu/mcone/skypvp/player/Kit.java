/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.player;

import eu.mcone.coresystem.api.bukkit.inventory.PlayerInventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Kit {

    public static final eu.mcone.gameapi.api.kit.Kit DEFAULT = new eu.mcone.gameapi.api.kit.Kit(
            "Standard-Kit",
            new ItemBuilder(Material.COAL)
                    .displayName("§7Standard-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §6Stein Schwert",
                            "§8» §6Angel",
                            "§8» §6Essen",
                            "§8» §616x Enderperlen",
                            "§8» §6Ketten Ausrüstung",
                            "",
                            "§7Kosten: §f0 Coins",
                            "§c§oDu hast dieses Kit immer!"
                    )
                    .itemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.STONE_SWORD)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.COOKIE, 20)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_8, new ItemBuilder(Material.GOLDEN_APPLE, 1)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.ENDER_PEARL, 16)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );


                put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.CHAINMAIL_HELMET, 1)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.CHAINMAIL_LEGGINGS, 1)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.CHAINMAIL_BOOTS, 1)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

            }},
            0
    );

    public static final eu.mcone.gameapi.api.kit.Kit IRON = new eu.mcone.gameapi.api.kit.Kit(
            "Eisen-Kit",
            new ItemBuilder(Material.IRON_BARDING)
                    .displayName("§7Eisen-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §6Eisen Schwert",
                            "§8» §6Angel",
                            "§8» §6Essen",
                            "§8» §616x Enderperlen",
                            "§8» §6Eisen Ausrüstung",
                            "",
                            "§7Kosten: §f20 Coins"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.IRON_SWORD)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.COOKIE, 20)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_8, new ItemBuilder(Material.GOLDEN_APPLE, 1)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.ENDER_PEARL, 16)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );


                put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.IRON_HELMET, 1)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.IRON_LEGGINGS, 1)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.IRON_CHESTPLATE, 1)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.IRON_BOOTS, 1)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

            }},
            20
    );

    public static final eu.mcone.gameapi.api.kit.Kit DIAMOND = new eu.mcone.gameapi.api.kit.Kit(
            "Diamanten-Kit",
            new ItemBuilder(Material.DIAMOND)
                    .displayName("§7Diamanten-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §6Diamanten Schwert",
                            "§8» §6Angel",
                            "§8» §6Essen",
                            "§8» §616x Enderperlen",
                            "§8» §6Diamanten Ausrüstung",
                            "",
                            "§7Kosten: §f50 Coins"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {
                {
                    put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.DIAMOND_SWORD)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );

                    put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );

                    put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.COOKIE, 20)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );

                    put(PlayerInventorySlot.HOTBAR_SLOT_8, new ItemBuilder(Material.GOLDEN_APPLE, 1)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );

                    put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.ENDER_PEARL, 16)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );


                    put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.DIAMOND_HELMET, 1)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );
                    put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.DIAMOND_LEGGINGS, 1)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );
                    put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );
                    put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.DIAMOND_BOOTS, 1)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );
                }
            },
            50
    );

    public static final eu.mcone.gameapi.api.kit.Kit EMERALD = new eu.mcone.gameapi.api.kit.Kit(
            "Emerald-Kit",
            new ItemBuilder(Material.EMERALD)
                    .displayName("§7Emerald-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §6Diamanten Schwert",
                            "§8» §6Angel",
                            "§8» §6Essen",
                            "§8» §616x Enderperlen",
                            "§8» §6Diamanten Ausrüstung",
                            "§6verzaubert",
                            "",
                            "§7Kosten: §f100 Coins"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {
                {
                    put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.DIAMOND_SWORD)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );

                    put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );

                    put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.COOKIE, 20)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );

                    put(PlayerInventorySlot.HOTBAR_SLOT_8, new ItemBuilder(Material.GOLDEN_APPLE, 1)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );

                    put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.ENDER_PEARL, 16)
                            .unbreakable(true)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .create()
                    );


                    put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.DIAMOND_HELMET, 1)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                            .create()
                    );
                    put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.DIAMOND_LEGGINGS, 1)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                            .create()
                    );
                    put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                            .create()
                    );
                    put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.DIAMOND_BOOTS, 1)
                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                            .enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                            .create()
                    );
                }
            },
            100
    );
}
