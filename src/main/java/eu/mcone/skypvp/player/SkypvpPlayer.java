/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.player;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
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
        return kits.contains(kit) || corePlayer.hasPermission(kit.getPermission());
    }

    public void buyAndSet(Kit kit) {
        Player bp = Bukkit.getPlayer(corePlayer.getUuid());

        if (hasKit(kit)) {
            Skypvp.getInstance().getMessager().send(bp, "§4Du besitzt dieses Kit bereits!");
        } else {
            if ((corePlayer.getCoins() - kit.getCoins()) >= 0) {
                corePlayer.removeCoins(kit.getCoins());
                kits.add(kit);
                Bukkit.getScheduler().runTaskAsynchronously(Skypvp.getInstance(), this::saveData);

                Skypvp.getInstance().getKitManager().setKit(this, kit);
                Skypvp.getInstance().getMessager().send(bp, "§2Du hast erfolgreich das Kit " + kit.getName() + "§2 gekauft!");
                bp.playSound(bp.getLocation(), Sound.LEVEL_UP, 1, 1);
            } else {
                Skypvp.getInstance().getMessager().send(bp, "§4Du hast nicht genügend Coins!");
                bp.playSound(bp.getLocation(), Sound.NOTE_BASS, 1, 1);
            }
        }
    }

    void setCurrentKit(Kit kit) {
        currentKit = kit;
    }

    public void resetCurrentKit() {
        currentKit = null;
    }

}
