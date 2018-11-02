/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp;

import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.skypvp.command.*;
import eu.mcone.skypvp.listener.*;
import eu.mcone.skypvp.player.KitManager;
import eu.mcone.skypvp.player.SkypvpPlayer;
import eu.mcone.skypvp.util.SidebarObjective;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Skypvp extends CorePlugin {

	public Skypvp() {
		super("skypvp", ChatColor.BLUE, "skypvp.prefix");
	}

	@Getter
    private static Skypvp instance;
    public static List<Player> cooldownlist = new ArrayList<>();
	private List<SkypvpPlayer> players;

	@Getter
	private KitManager kitManager;
	@Getter
	private BuildSystem buildSystem;
	@Getter
	private CoreWorld world;

    public void onEnable() {
        instance = this;
        players = new ArrayList<>();

        world = CoreSystem.getInstance().getWorldManager().getWorld("Skypvp");
        PlayerDataProfile.doSetGameProfileWorld(world.bukkit());
        CoreSystem.getInstance().getTranslationManager().loadCategories(this);
        
		sendConsoleMessage("§aKit Manager wird initiiert...");
		kitManager = new KitManager();

		sendConsoleMessage("§aBuild-System witd initiiert...");
		buildSystem = CoreSystem.getInstance().initialiseBuildSystem(BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);

		sendConsoleMessage("§aEvents und Befehle werden registriert...");
        registerCommands();
        registerEvents();

		sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");

		for (CorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
		    p.getScoreboard().setNewObjective(new SidebarObjective());
		    new SkypvpPlayer(p);
        }
    }

    public void onDisable(){
        for (SkypvpPlayer sp : getSkypvpPlayers()) {
            sp.saveData();
        }

		sendConsoleMessage("§cPlugin wurde deaktiviert!");
    }

    private void registerCommands() {
    	registerCommands(
    			new EndechestCMD(),
				new KitCMD(),
				new RandomCMD(),
				new ShopCMD(),
				new SpawnCMD(),
				new WorkbenchCMD()
		);
    }

    private void registerEvents() {
    	registerEvents(
    			new CoinsChange(),
				new EntityDamage(),
				new EntityDamageByEntity(),
				new PlayerBedEnter(),
				new PlayerDeath(),
				new PlayerInteractEntity(),
				new PlayerJoin(),
				new PlayerMove(),
				new PlayerQuit(),
				new PlayerRespawn(),
				new StatsChange()
		);
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

}
