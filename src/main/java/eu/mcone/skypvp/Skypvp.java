/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.EnderchestManager;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.EnderchestManagerGetter;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.gameapi.api.Option;
import eu.mcone.skypvp.command.*;
import eu.mcone.skypvp.listener.*;
import eu.mcone.skypvp.player.Kit;
import eu.mcone.skypvp.player.SkypvpPlayer;
import eu.mcone.skypvp.util.SidebarObjective;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Skypvp extends GamePlugin implements EnderchestManagerGetter {

    public Skypvp() {
        super(Gamemode.SKYPVP, "skypvp.prefix", Option.KIT_MANAGER_APPLY_KITS_ONCE);
    }

    @Getter
    private static Skypvp instance;
    private List<SkypvpPlayer> players;
    @Getter
    private BuildSystem buildSystem;
    @Getter
    private CoreWorld world;

    @Override
    public void onGameEnable() {
        instance = this;
        players = new ArrayList<>();

        world = CoreSystem.getInstance().getWorldManager().getWorld("Skypvp");
        PlayerDataProfile.doSetGameProfileWorld(world.bukkit());

        sendConsoleMessage("§aInitializing Kit Manager...");
        getKitManager().registerKits(Kit.DEFAULT, Kit.IRON, Kit.EMERALD, Kit.DIAMOND);

        sendConsoleMessage("§aInitializing Build-System...");
        buildSystem = CoreSystem.getInstance().initialiseBuildSystem(BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);

        sendConsoleMessage("§aRegistering Events & Commands...");
        registerCommands(
                new EndechestCMD(),
                new KitCMD(),
                new RandomCMD(),
                new ShopCMD(),
                new WorkbenchCMD()
        );
        registerEvents(
                new EntityDamageListener(),
                new GeneralPlayerListener(),
                new NpcInteract(),
                new PlayerDeathListener(),
                new PlayerInteractEntity(),
                new PlayerUpdateListener()
        );
        CoreSystem.getInstance().enableSpawnCommand(this, world, 3);
        CoreSystem.getInstance().enableTpaSystem(this, 3);
        CoreSystem.getInstance().enableEnderchestSystem(this);

        for (CorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
            p.getScoreboard().setNewObjective(new SidebarObjective());
            new SkypvpPlayer(p);
        }

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a enabled...");
    }

    @Override
    public void onGameDisable() {
        for (SkypvpPlayer sp : getSkypvpPlayers()) {
            sp.saveData();
        }

        sendConsoleMessage("§cPlugin disabled!");
    }

    public SkypvpPlayer getSkypvpPlayer(UUID uuid) {
        for (SkypvpPlayer sp : players) {
            if (sp.getCorePlayer().getUuid().equals(uuid)) {
                return sp;
            }
        }
        return null;
    }

    public SkypvpPlayer getSkypvpPlayer(String name) {
        for (SkypvpPlayer sp : players) {
            if (sp.getCorePlayer().getName().equals(name)) {
                return sp;
            }
        }
        return null;
    }

    public Collection<SkypvpPlayer> getSkypvpPlayers() {
        return players;
    }

    public void registerSkypvpPlayer(SkypvpPlayer sp) {
        players.add(sp);
    }

    public void unregisterSkypvpPlayer(SkypvpPlayer sp) {
        players.remove(sp);
    }

    @Override
    public EnderchestManager getEnderchestManager(Player player) {
        return getSkypvpPlayer(player.getUniqueId());
    }

}
