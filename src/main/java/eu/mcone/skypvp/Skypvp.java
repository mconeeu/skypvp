/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp;

import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.StatsAPI;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.coresystem.api.core.gamemode.Gamemode;
import eu.mcone.skypvp.command.*;
import eu.mcone.skypvp.kit.KitManager;
import eu.mcone.skypvp.listener.*;
import eu.mcone.skypvp.util.SidebarObjective;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.*;

import static org.bukkit.Bukkit.getPluginManager;

public class Skypvp extends CorePlugin {

	public Skypvp() {
		super("Skypvp", ChatColor.BLUE, "skypvp.prefix");
	}

	@Getter
    private static Skypvp instance;

	public static List<Player> cooldownlist = new ArrayList<>();
	public static Map<Player, Map<Long, UUID>> damager = new HashMap<>();

	@Getter
	private StatsAPI statsAPI;
	@Getter
	private KitManager kitManager;
	@Getter
	private BuildSystem buildSystem;
	@Getter
	private CoreWorld world;

    public void onEnable() {
        instance = this;
        world = CoreSystem.getInstance().getWorldManager().getWorld("Skypvp");
        CoreSystem.getInstance().getTranslationManager().loadCategories(this);

		sendConsoleMessage("§aNPC-Manager wird initiiert...");
		statsAPI = CoreSystem.getInstance().getStatsAPI(Gamemode.SKYPVP);
        
		sendConsoleMessage("§aKit Manager wird initiiert...");
		kitManager = new KitManager(CoreSystem.getInstance().getMySQL());
		kitManager.createMySQLTable();

		sendConsoleMessage("§aBuild-System witd initiiert...");
		buildSystem = CoreSystem.getInstance().initialiseBuildSystem(BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);

		sendConsoleMessage("§aEvents und Befehle werden registriert...");
        registerCommands();
        registerEvents();

		sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");

		for (CorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
		    p.getScoreboard().setNewObjective(new SidebarObjective());
        }
    }

    public void onDisable(){
		sendConsoleMessage("§cPlugin wurde deaktiviert!");
        kitManager.getAsyncRunnable().cancel();
    }

    private void registerCommands() {
    	getCommand("ec").setExecutor(new EndechestCMD());
    	getCommand("shop").setExecutor(new ShopCMD());
    	getCommand("wb").setExecutor(new WorkbenchCMD());
    	getCommand("kit").setExecutor(new KitCMD());
    	getCommand("spawn").setExecutor(new SpawnCMD());
    	getCommand("random").setExecutor(new RandomCMD());
    }

    private void registerEvents() {
        getPluginManager().registerEvents(new CoinsChange(), this);
        getPluginManager().registerEvents(new EntityDamage(),this);
        getPluginManager().registerEvents(new EntityDamageByEntity(),this);
        getPluginManager().registerEvents(new PlayerBedEnter(),this);
        getPluginManager().registerEvents(new PlayerDeath(),this);
        getPluginManager().registerEvents(new PlayerInteractEntity(),this);
        getPluginManager().registerEvents(new PlayerJoin(),this);
        getPluginManager().registerEvents(new PlayerMove(),this);
        getPluginManager().registerEvents(new PlayerQuit(),this);
        getPluginManager().registerEvents(new PlayerRespawn(),this);
		getPluginManager().registerEvents(new StatsChange(),this);
    }

}
