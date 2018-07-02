/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp;

import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.npc.NpcManager;
import eu.mcone.coresystem.api.bukkit.player.BukkitCorePlayer;
import eu.mcone.coresystem.api.bukkit.player.StatsAPI;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.coresystem.api.core.gamemode.Gamemode;
import eu.mcone.coresystem.api.core.translation.TranslationField;
import eu.mcone.skypvp.command.*;
import eu.mcone.skypvp.kit.KitManager;
import eu.mcone.skypvp.listener.*;
import eu.mcone.skypvp.util.Objective;
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
	private NpcManager npcManager;
	@Getter
	private BuildSystem buildSystem;
	@Getter
	private CoreWorld world;

    public void onEnable() {
        instance = this;
        world = CoreSystem.getInstance().getWorldManager().getWorld("Skypvp");
        registerTranslations();

		sendConsoleMessage("§aNPC-Manager wird initiiert...");
		statsAPI = CoreSystem.getInstance().getStatsAPI(Gamemode.SKYPVP);
        
		sendConsoleMessage("§aKit Manager wird initiiert...");
		kitManager = new KitManager(CoreSystem.getInstance().getMySQL());
		kitManager.createMySQLTable();

		sendConsoleMessage("§aNPC-Manager wird gestartet...");
		npcManager = CoreSystem.getInstance().initialiseNpcManager(this);

		sendConsoleMessage("§aBuild-System witd initiiert...");
		buildSystem = CoreSystem.getInstance().initialiseBuildSystem(BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);

		sendConsoleMessage("§aEvents und Befehle werden registriert...");
        registerCommands();
        registerEvents();

		sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");

		for (BukkitCorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
		    p.getScoreboard().setNewObjective(new Objective());
        }
    }

    public void onDisable(){
		sendConsoleMessage("§cPlugin wurde deaktiviert!");
        kitManager.getAsyncRunnable().cancel();
		npcManager.unsetNPCs();
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

	private void registerTranslations(){
		CoreSystem.getInstance().getTranslationManager().insertIfNotExists(
				new HashMap<String, TranslationField>(){{
					put("skypvp.prefix", new TranslationField("&8[&7&l!&8] &9SkyPvP &8» "));
					put("skypvp.join", new TranslationField("&f%player% &7betritt &9SkyPvP§7."));
					put("skypvp.quit", new TranslationField("&f%player% &7verlässt &9SkyPvP§7."));
					put("skypvp.itemframe", new TranslationField("&8» &9&lSkyPvP &7Free Items"));
					put("skypvp.scoreboard.1", new TranslationField("&3&lMCONE.EU"));
					put("skypvp.scoreboard.2", new TranslationField("&8» &7Kills:"));
					put("skypvp.scoreboard.3", new TranslationField(" &9"));
					put("skypvp.scoreboard.4", new TranslationField("&8» &7Tode:"));
					put("skypvp.scoreboard.5", new TranslationField(" &c"));
					put("skypvp.scoreboard.6", new TranslationField("&8» &7Coins:"));
					put("skypvp.scoreboard.7", new TranslationField(" &f"));
					put("skypvp.scoreboard.8", new TranslationField("&8» &7Event"));
					put("skypvp.scoreboard.9", new TranslationField(" &8&oNichts geplant"));
					put("skypvp.scoreboard.10", new TranslationField("&f§lMCONE.EU"));
				}}
		);
	}

}
