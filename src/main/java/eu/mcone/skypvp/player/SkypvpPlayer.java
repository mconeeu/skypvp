/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.player;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.skypvp.Skypvp;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.List;

public class SkypvpPlayer extends GamePlayerInventory<SkypvpPlayerProfile> {

    @Getter
    private List<Kit> kits;
    @Getter
    private Kit currentKit;

    public SkypvpPlayer(CorePlayer corePlayer) {
        super(corePlayer);
        Skypvp.getInstance().registerSkypvpPlayer(this);
    }

    @Override
    public SkypvpPlayerProfile reload() {
        SkypvpPlayerProfile profile = super.reload();
        this.kits = profile.getKitList();

        return profile;
    }

    @Override
    protected SkypvpPlayerProfile loadData() {
        return Skypvp.getInstance().loadGameProfile(corePlayer.bukkit(), SkypvpPlayerProfile.class);
    }

    @Override
    public void saveData() {
        Skypvp.getInstance().saveGameProfile(new SkypvpPlayerProfile(corePlayer.bukkit(), enderchest));
    }

    public boolean hasKit(Kit kit) {
        return kits.contains(kit) || corePlayer.hasPermission("skypvp.kits." + Skypvp.getInstance().getKitManager().getKit(Kit.DIAMOND.getName())) ||
                corePlayer.hasPermission("skypvp.kits." + Skypvp.getInstance().getKitManager().getKit(Kit.EMERALD.getName()))
                || corePlayer.hasPermission("skypvp.kits." + Skypvp.getInstance().getKitManager().getKit(Kit.IRON.getName()));
    }


    void setCurrentKit(Kit kit) {
        currentKit = kit;
    }

    public void resetCurrentKit() {
        currentKit = null;
    }

}
