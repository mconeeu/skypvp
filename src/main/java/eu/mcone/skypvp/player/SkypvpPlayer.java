/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.player;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerInventoryProfile;
import eu.mcone.skypvp.Skypvp;

public class SkypvpPlayer extends GamePlayerInventory<PlayerInventoryProfile> {

    public SkypvpPlayer(CorePlayer corePlayer) {
        super(corePlayer);
        Skypvp.getInstance().registerSkypvpPlayer(this);
    }

    @Override
    protected PlayerInventoryProfile loadData() {
        return Skypvp.getInstance().loadGameProfile(corePlayer.bukkit(), PlayerInventoryProfile.class);
    }

    @Override
    public void saveData() {
        Skypvp.getInstance().saveGameProfile(new PlayerInventoryProfile(corePlayer.bukkit(), enderchest));
    }

}
