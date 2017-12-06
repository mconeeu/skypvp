/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp;

import eu.mcone.bukkitcoresystem.CoreSystem;
import eu.mcone.bukkitcoresystem.config.MySQL_Config;
import eu.mcone.bukkitcoresystem.event.CoinsChangeEvent;
import eu.mcone.bukkitcoresystem.player.CorePlayer;
import eu.mcone.skypvp.kit.KitManager;
import eu.mcone.skypvp.command.*;
import eu.mcone.skypvp.listener.*;
import eu.mcone.skypvp.util.Objective;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getPluginManager;


public class Main extends JavaPlugin{

    private static Main instance;
	public static MySQL_Config config;
	public static KitManager kits;

    private static String MainPrefix = "§8[§9SkyPvP§8] ";
	public static ArrayList<Player> cooldownlist = new ArrayList<>();

    public void onEnable() {
        instance = this;

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aMySQL Config wird initiiert...");
        config = new MySQL_Config(CoreSystem.mysql3, "Skypvp", 1000);
        registerMySQLConfig();

		Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aKit Manager wird initiiert...");
		kits = new KitManager(CoreSystem.mysql1);
		kits.createMySQLTable();

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aEvents und Befehle werden registriert...");
        registerCommands();
        registerEvents();

		for (World w : Bukkit.getServer().getWorlds()) {
			w.setAutoSave(false);
		}

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");

		for (CorePlayer p : CoreSystem.getOnlineCorePlayers()) {
		    new Objective(p);
        }
    }

    public void onDisable(){
        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§cPlugin wurde deaktiviert!");
        kits.getAsyncRunnable().cancel();
    }
    
    private void registerCommands() {
    	getCommand("ec").setExecutor(new Endechest_CMD());
    	getCommand("shop").setExecutor(new Shop_CMD());
    	getCommand("wb").setExecutor(new Workbench_CMD());
    	getCommand("kit").setExecutor(new Kit_CMD());
    	getCommand("spawn").setExecutor(new Spawn_CMD());
    	getCommand("random").setExecutor(new Random_CMD());
    }

    private void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new BlockBreak(),this);
		Bukkit.getPluginManager().registerEvents(new BlockPlace(),this);
        Bukkit.getPluginManager().registerEvents(new CoinsChange(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamage(),this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageByEntity(),this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerBedEnter(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractEntity(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerRespawn(),this);
        Bukkit.getPluginManager().registerEvents(new WeatherChange(),this);
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
      
	public static Main getInstance(){
	return instance;
	}
}
