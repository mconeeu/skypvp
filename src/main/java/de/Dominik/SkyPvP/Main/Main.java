package de.Dominik.SkyPvP.Main;

import java.io.File;
import java.io.IOException;

import de.Dominik.BukkitCoreSystem.API.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.Dominik.SkyPvP.Command.Endechest_CMD;
import de.Dominik.SkyPvP.Command.Feed_CMD;
import de.Dominik.SkyPvP.Command.Head_CMD;
import de.Dominik.SkyPvP.Command.Heal_CMD;
import de.Dominik.SkyPvP.Command.Kit_CMD;
import de.Dominik.SkyPvP.Command.Kits_CMD;
import de.Dominik.SkyPvP.Command.Random_CMD;
import de.Dominik.SkyPvP.Command.SetSpawnKits_CMD;
import de.Dominik.SkyPvP.Command.SetSpawnShop_CMD;
import de.Dominik.SkyPvP.Command.Spawn_CMD;
import de.Dominik.SkyPvP.Command.SpawnManager_CMD;
import de.Dominik.SkyPvP.Command.Wokrbench_CMD;
import de.Dominik.SkyPvP.Event.BlockBreakEvent_EVENT;
import de.Dominik.SkyPvP.Event.BlockPlaceEvent_EVENT;
import de.Dominik.SkyPvP.Event.PlayerAchievementAwardedEvent_EVENT;
import de.Dominik.SkyPvP.Event.PlayerBedEnterEvent_EVENT;
import de.Dominik.SkyPvP.Event.PlayerItemBreakEvent_EVENT;
import de.Dominik.SkyPvP.Event.PlayerJoinEvent_EVENT;
import de.Dominik.SkyPvP.Event.PlayerMoveEvent_EVENT;
import de.Dominik.SkyPvP.Event.PlayerQuitEvent_EVENT;
import de.Dominik.SkyPvP.Event.WeatherChangeEvent_EVENT;
import de.Dominik.SkyPvP.Listener.Frame_LISTENER;
import de.Dominik.SkyPvP.Listener.InventoryClick_LISTENER;
import de.Dominik.SkyPvP.Listener.Item_LISTENER;
import de.Dominik.SkyPvP.Listener.Kill_LISTENER;
import de.Dominik.SkyPvP.Listener.KitsGolem_LISTENER;
import de.Dominik.SkyPvP.Listener.Listener_LISTENER;
import de.Dominik.SkyPvP.Listener.Scoreboard_LISTENER;
import de.Dominik.SkyPvP.Listener.Shop_LISTENER;
import de.Dominik.SkyPvP.Shop.Shop;
import de.Dominik.SkyPvP.Shop.ShopListener;
import de.Dominik.SkyPvP.Utils.Items_Util;


public class Main extends JavaPlugin{
    public static Location loc;
    public static String Output;

    private static Main instance;
    
    public static File f = new File("plugins/McOne-SkyPvP", "config.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
    
    public static double a;
	public static Plugin plugin;
    public String pc;
    public static Main main;
    
    public void onEnable() {
        setInstance(this);
        main = this;
        registerCommands();
        setupConfig();
        
        Bukkit.getConsoleSender().sendMessage("§7--------- §3SkyPvP System §7---------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin Name: §3" + main.getDescription().getName());
        Bukkit.getConsoleSender().sendMessage("§7Plugin author: §3" + main.getDescription().getAuthors());
        Bukkit.getConsoleSender().sendMessage("§7Plugin Version: §3" +  main.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage("§7--------- §3SkyPvP System §7---------");
    	
        Bukkit.getPluginManager().registerEvents(new Items_Util(),this);
        
        //Bukkit.getPluginManager().registerEvents(new Title_API(),this);
    	
        Bukkit.getPluginManager().registerEvents(new Scoreboard_LISTENER(),this);
        
        Bukkit.getPluginManager().registerEvents(new Frame_LISTENER(),this);
        //Bukkit.getPluginManager().registerEvents(new Sing_LISTENER(),this);
        Bukkit.getPluginManager().registerEvents(new Item_LISTENER(),this);
        Bukkit.getPluginManager().registerEvents(new Kill_LISTENER(this),this);
        Bukkit.getPluginManager().registerEvents(new KitsGolem_LISTENER(),this);
        Bukkit.getPluginManager().registerEvents(new Listener_LISTENER(this),this);
        Bukkit.getPluginManager().registerEvents(new Shop_LISTENER(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick_LISTENER(), this);
        
        Bukkit.getPluginManager().registerEvents(new ShopListener(), this);
        
        Bukkit.getPluginManager().registerEvents(new PlayerQuitEvent_EVENT(),this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakEvent_EVENT(),this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent_EVENT(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerBedEnterEvent_EVENT(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerItemBreakEvent_EVENT(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent_EVENT(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveEvent_EVENT(),this);
        Bukkit.getPluginManager().registerEvents(new WeatherChangeEvent_EVENT(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerAchievementAwardedEvent_EVENT(), this);
        
    }
    
    private void registerCommands() {
    	getCommand("ec").setExecutor(new Endechest_CMD());
    	getCommand("shop").setExecutor(new Shop());
    	getCommand("wb").setExecutor(new Wokrbench_CMD());
    	getCommand("heal").setExecutor(new Heal_CMD());
    	getCommand("feed").setExecutor(new Feed_CMD());
    	getCommand("head").setExecutor(new Head_CMD());
    	getCommand("kit").setExecutor(new Kit_CMD());
    	getCommand("kits").setExecutor(new Kits_CMD());
    	getCommand("setspawnshop").setExecutor(new SetSpawnShop_CMD());
    	getCommand("setspawnkits").setExecutor(new SetSpawnKits_CMD());
    	getCommand("set").setExecutor(new SpawnManager_CMD());
    	getCommand("spawn").setExecutor(new Spawn_CMD());
    	getCommand("random").setExecutor(new Random_CMD());
    	
    }
    
    private void setupConfig() {
	    if (!f.exists()) {
	      try{
	        f.createNewFile();
	      }catch (IOException e){
	        e.printStackTrace();
	      }
	    }

	    getConfig().options().header(""
	    		+ "Plugin Entwickler: xXTwinsterHDXx"
	    		+ "\nPlugin Version: 2.0"
	    		+ "\n--> Kommand Permissons <--"
	    		+ "\nEnderchest: SkyPvP.ec"
	    		+ "\nFeed: SkyPvP.Feed"
	    		+ "\nHead: SkyPvP.Head"
	    		+ "\nSetShop: SkyPvP.Setshop"
	    		+ "\nSetSpawn: SkyPvP.Setspawn"
	    		+ "\nSetKits: SkyPvP.Setkits"
	    		+ "\nWorkbench: SkyPvP.wb"
	    		+ "\n--> Extra Permissons <--"
	    		+ "\nFrame Remove: SkyPvP.Removeframe"
	    		+ "\n--> Kit Permissons <--"
	    		+ "\nSkyPvP.Diamond"
	    		+ "\nSkyPvP.emerald"
	    		+ "\nSkyPvP.platin"
	    		+ "\n--> Admin Permissons <--"
	    		+ "\nSkyPvP.*"
	    		+ "\noder"
	    		+ "\nSystem.*");
	    getConfig().options().copyDefaults(true);
	    
	    getConfig().addDefault("SkyPvP.Server-Prefix", "&8[&7&l!&8] &9SkyPvP &8>");
	    getConfig().addDefault("SkyPvP.No-Perm", " &4Du hast keine Berechtigung für diesen Befehl");
	    getConfig().addDefault("SkyPvP.Konsolen-Sender", " &7Nur ein &cSpieler &7Kann diesen Befehl ausführen!");
	    getConfig().addDefault("SkyPvP.ItemFrame", "&8> &9&lSkyPvP &7Free Items");
	    getConfig().addDefault("SkyPvP.Join", "&f%Player% &7hat den &9SkyPvP-Server &7betreten");
	    getConfig().addDefault("SkyPvP.Quit", "&f%Player% &7hat den &9SkyPvP-Server &7verlassen");
	    getConfig().addDefault("SkyPvP.ScoreBoard-1", "&3&lMCONE.EU");
	    getConfig().addDefault("SkyPvP.ScoreBoard-2", "&8> &7Kills:");
	    getConfig().addDefault("SkyPvP.ScoreBoard-3", " &9");
	    getConfig().addDefault("SkyPvP.ScoreBoard-4", "&8> &7Tode:");
	    getConfig().addDefault("SkyPvP.ScoreBoard-5", " &c");
	    getConfig().addDefault("SkyPvP.ScoreBoard-6", "&8> &7Coins:");
	    getConfig().addDefault("SkyPvP.ScoreBoard-7", " &f");
	    getConfig().addDefault("SkyPvP.ScoreBoard-8", "&8> &7Event");
	    getConfig().addDefault("SkyPvP.ScoreBoard-9", " &8&oNichts geplant");
	    
	    getConfig().addDefault("GameAPI-Tablist-Spielverderber","&8[&7SV&8] &8");
	    getConfig().addDefault("GameAPI-Tablist-Spieler","&8[&fS&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-Premium","&8[&6P&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-Premium+","&8[&6P+&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-YouTuber","&8[&5YT&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-Team","&7[c&C&7] &4");
	    getConfig().addDefault("GameAPI-Tablist-Supporter","&8[&aSup&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-Moderator","&8[&2Mod&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-SrModerator","&8[&2SrMod&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-JrSupporter","&8[&aJrSup&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-Builder","&8[&eB&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-Developer","&8[&bDev&8] &7");
	    getConfig().addDefault("GameAPI-Tablist-Admin","&8[&cA&8] &7");
	    
	    
	    saveConfig();
	  }
	
    public void loadConfig(){
      FileConfiguration cfg = getConfig();
      cfg.options().copyDefaults(true);
      
      saveConfig();
    }
    
    public void setInstance(Main instance){
        instance = instance;
      }
      
      public static Main getInstance(){
        return instance;
  	}
      public static Plugin getInstance1(){
        return main;
    }
}
