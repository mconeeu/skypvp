/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp;

import eu.mcone.bukkitcoresystem.CoreSystem;
import eu.mcone.bukkitcoresystem.api.NpcAPI;
import eu.mcone.bukkitcoresystem.command.NpcCMD;
import eu.mcone.bukkitcoresystem.config.MySQL_Config;
import eu.mcone.bukkitcoresystem.player.CorePlayer;
import eu.mcone.gameapi.api.StateAPI;
import eu.mcone.skypvp.kit.KitManager;
import eu.mcone.skypvp.command.*;
import eu.mcone.skypvp.listener.*;
import eu.mcone.skypvp.util.Objective;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

import static org.bukkit.Bukkit.getPluginManager;


public class SkyPvP extends JavaPlugin{

    private static SkyPvP instance;
	public static MySQL_Config config;
	public static KitManager kits;
	public static NpcAPI npc;

    private static String MainPrefix = "§8[§9SkyPvP§8] ";
	public static List<Player> cooldownlist = new ArrayList<>();
	public static Map<Player, Map<Long, UUID>> damager = new HashMap<>();

    public void onEnable() {
        instance = this;

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aMySQL Config wird initiiert...");
        config = new MySQL_Config(CoreSystem.mysql3, "Skypvp", 1000);
        registerMySQLConfig();

		Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aKit Manager wird initiiert...");
		kits = new KitManager(CoreSystem.mysql1);
		kits.createMySQLTable();

		Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aNPC-Manager wird gestartet");
		npc = new NpcAPI(eu.mcone.bukkitcoresystem.CoreSystem.mysql1, "Skypvp");

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aEvents und Befehle werden registriert...");
        registerCommands();
        registerEvents();

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");
		StateAPI.setState(StateAPI.State.WAITING);

		for (CorePlayer p : CoreSystem.getOnlineCorePlayers()) {
		    p.getScoreboard().setNewObjective(new Objective(p));
        }
    }

    public void onDisable(){
        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§cPlugin wurde deaktiviert!");
        kits.getAsyncRunnable().cancel();
		npc.unsetNPCs();
    }

    private void registerCommands() {
    	getCommand("ec").setExecutor(new EndechestCMD());
    	getCommand("shop").setExecutor(new ShopCMD());
    	getCommand("wb").setExecutor(new WorkbenchCMD());
    	getCommand("kit").setExecutor(new KitCMD());
    	getCommand("spawn").setExecutor(new SpawnCMD());
    	getCommand("random").setExecutor(new RandomCMD());
		getCommand("npc").setExecutor(new NpcCMD(npc));
    }

    private void registerEvents() {
		getPluginManager().registerEvents(new BlockBreak(),this);
		getPluginManager().registerEvents(new BlockPlace(),this);
        getPluginManager().registerEvents(new CoinsChange(), this);
        getPluginManager().registerEvents(new EntityDamage(),this);
        getPluginManager().registerEvents(new EntityDamageByEntity(),this);
		getPluginManager().registerEvents(new HangingBreakByEntity(),this);
        getPluginManager().registerEvents(new InventoryClick(),this);
        getPluginManager().registerEvents(new PlayerBedEnter(),this);
        getPluginManager().registerEvents(new PlayerDeath(),this);
        getPluginManager().registerEvents(new PlayerInteractEntity(),this);
        getPluginManager().registerEvents(new PlayerJoin(),this);
        getPluginManager().registerEvents(new PlayerMove(),this);
        getPluginManager().registerEvents(new PlayerQuit(),this);
        getPluginManager().registerEvents(new PlayerRespawn(),this);
		getPluginManager().registerEvents(new StatsChange(),this);
    }

	private void registerMySQLConfig(){
		//create table
		config.createTable();

    	//System
	    config.insertMySQLConfig("System-Prefix", "&8[&7&l!&8] &9SkyPvP &8» ");
	    config.insertMySQLConfig("System-No-Perm", "&4Du hast keine Berechtigung für diesen Befehl");
	    config.insertMySQLConfig("System-Konsolen-Sender", "&7Nur ein &cSpieler &7Kann diesen Befehl ausführen!");
		config.insertMySQLConfig("System-Join", "&f%Player% &7betritt &9SkyPvP§7.");
		config.insertMySQLConfig("System-Quit", "&f%Player% &7verlässt &9SkyPvP§7.");
		config.insertMySQLConfig("System-ItemFrame", "&8» &9&lSkyPvP &7Free Items");

        //Locations
        config.insertMySQLConfig("Location-Spawn", "[\"\",\"\",\"\",\"\",\"\",\"\"]");

		//Scoreboard
		config.insertMySQLConfig("ScoreBoard-1", "&3&lMCONE.EU");
	    config.insertMySQLConfig("ScoreBoard-2", "&8» &7Kills:");
	    config.insertMySQLConfig("ScoreBoard-3", " &9");
	    config.insertMySQLConfig("ScoreBoard-4", "&8» &7Tode:");
	    config.insertMySQLConfig("ScoreBoard-5", " &c");
	    config.insertMySQLConfig("ScoreBoard-6", "&8» &7Coins:");
	    config.insertMySQLConfig("ScoreBoard-7", " &f");
	    config.insertMySQLConfig("ScoreBoard-8", "&8» &7Event");
	    config.insertMySQLConfig("ScoreBoard-9", " &8&oNichts geplant");

		//store
		config.store();
	}
      
	public static SkyPvP getInstance(){
	return instance;
	}
}
