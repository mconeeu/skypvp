/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.player;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import eu.mcone.skypvp.Skypvp;

public class SkypvpPlayer extends GamePlayerInventory<SkypvpPlayerProfile> {

    private int crates;

    public SkypvpPlayer(CorePlayer corePlayer) {
        super(corePlayer);
        Skypvp.getInstance().registerSkypvpPlayer(this);
    }

    @Override
    public SkypvpPlayerProfile reload() {
        SkypvpPlayerProfile profile = super.reload();
        crates = profile.getCrates();

        return profile;
    }

    @Override
    protected SkypvpPlayerProfile loadData() {
        return Skypvp.getInstance().loadGameProfile(corePlayer.bukkit(), SkypvpPlayerProfile.class);
    }

    @Override
    public void saveData() {
        Skypvp.getInstance().saveGameProfile(new SkypvpPlayerProfile(corePlayer.bukkit(), enderchest, crates));
    }

}
