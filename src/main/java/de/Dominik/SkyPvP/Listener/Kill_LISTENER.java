package de.Dominik.SkyPvP.Listener;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

import de.Dominik.BukkitCoreSystem.API.CoinsAPI;
import de.Dominik.BukkitCoreSystem.API.StatsAPI;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
     
public class Kill_LISTENER implements Listener {
private HashMap< Player, Player > lastHit = new HashMap<>();
public static Plugin plugin;
         
         public Kill_LISTENER(Plugin plugin){
        	 Kill_LISTENER.plugin = plugin;
         }
         
         @EventHandler
     	public void onPlayerHit(EntityDamageByEntityEvent e) {
     		if(!(e.getEntity() instanceof Player)) {
     			return;
     		}
     		
     		Entity ent = (Player) e.getEntity();	
     		 ent.getWorld().playEffect(ent.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
     	}
         
         @EventHandler
         public void onDamage(PlayerDeathEvent e) {
        	 try{
        		 Player p = e.getEntity();
         	    Player k = p.getKiller();
         	    if(lastHit instanceof Player) {
         	        lastHit.put(k, p);
         	    }
        	 }catch(NullPointerException e1){
        		 e1.printStackTrace();
        	 }
        }
         
         @EventHandler
         public void on(PlayerMoveEvent e){
        	 if(e.getTo().getY() <= -50){
        		 e.getPlayer().setHealth(0.0D);
        		 }
         }   
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
    	try{
    		final Player p = e.getEntity();
    	       Player k = e.getEntity().getKiller();

    	       EntityPlayer en = ((CraftPlayer) p).getHandle();
    	       en.getLastDamager();
    	         
    	       e.setDeathMessage(null);
    	       e.getDrops().clear();
    	       Respawn(p, 1);
    	       p.setLevel(0);
    	       
    	       p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1.0F, 1.0F);
    	       
    	       if(k instanceof Player){
    	    	   int coins2 = CoinsAPI.getCoins(p) - 1;
					 if(coins2 <= -1){
						 
					 }else{
						//Coins werden dem Spieler Angezogen (3)
						 CoinsAPI.removeCoins(p, Integer.valueOf(3)); 
					 }

                   //Tode werden dem Spieler Hinzugefügt (1)
				   StatsAPI.addDeaths(p.getUniqueId().toString(), p.getName(), Integer.valueOf(1));
				   
				   //Scoreboard wird für denn Spieler gesetzt (p)
    	    	   Scoreboard_LISTENER.setScoreboard1(p);
				   
    	    	   int i = k.getLevel();
    	           i++;
    	           k.setLevel(i);
    	           checkLevel(i, k);
    	           
    	    	   k.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §7Du hast §6" + p.getDisplayName() + " §7getötet");
    	    	   
    	       }
    	       
    	       if(!(k instanceof Player)){
    	    	   
    	    	   int coins2 = CoinsAPI.getCoins(p) - 1;
					 if(coins2 <= -1){
						 
					 }else{
						 //Coins werden dem Spieler Angezogen (3)
						 CoinsAPI.removeCoins(p, Integer.valueOf(3)); 
					 }
    	    	   //Tod wird dem Spieler hinzugefügt
    	    	   StatsAPI.addDeaths(p.getUniqueId().toString(), p.getName(), Integer.valueOf(1));
    	    	   
    	    	   //Scoreboard wird für denn Spieler gesetzt (p)
    	    	   Scoreboard_LISTENER.setScoreboard1(p);
    	    	   
    	    	   p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §7Du bist gestorben");
    	       }
/**
    	       if((p instanceof Player)){
    	    	   int coins2 = CoinsAPI.getCoins(p) - 1;
					 if(coins2 <= -1){
						 
					 }else{
						 //Coins werden dem Spieler Angezogen (3)
						 CoinsAPI.removeCoins(p, Integer.valueOf(3)); 
					 }
                   //Tode werden dem Spieler Hinzugefügt (1)
				   StatsAPI.addDeaths(p.getUniqueId().toString(), p.getName(), Integer.valueOf(1));
				   Bukkit.broadcastMessage("§c//Tode werden dem Spieler Hinzugefügt (1)-2");
				   
				   //Scoreboard wird für denn Spieler gesetzt (p)
    	    	   Scoreboard_LISTENER.setScoreboard1(p);
				   
				   //Coins werden dem Killer Hinzugefügt (3)
    	    	   CoinsAPI.addCoins(k, Integer.valueOf(3));

    	    	   //Kills werden dem Killer Hinzugefügt (1)
    	    	   StatsAPI.addKills(k.getUniqueId().toString(), k.getName(), Integer.valueOf(1));
    	    	   
    	    	   //Scorebaord wird für denn Killer Gesetzt (k)
    	    	   Scoreboard_LISTENER.setScoreboard1(k);
    	       }
*/
    	       if(p instanceof Player){

					 //Coins werden dem Killer Hinzugefügt (3)
	    	    	   CoinsAPI.addCoins(k, Integer.valueOf(3));

	    	    	   //Kills werden dem Killer Hinzugefügt (1)
	    	    	   StatsAPI.addKills(k.getUniqueId().toString(), k.getName(), Integer.valueOf(1));
	    	    	   
	    	    	   //Scorebaord wird für denn Killer Gesetzt (k)
	    	    	   Scoreboard_LISTENER.setScoreboard1(k);
	    	    	   
    	    	   
    	    	   p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §7Du wurdest von §6" + k.getDisplayName() + " §7getötet");
    	       }
    	       
    	       if(lastHit.containsKey(p)) {
    				lastHit.get(p);	
    				lastHit.remove(p);
    			}
    	}catch(NullPointerException e1){
   		 e1.printStackTrace();
    	}
       
    }
    
    public void checkLevel(int i, Player p){
  	
  	if (i == 3) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c3er §6Killstreak!");
	      p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "§") + " §eDu hast 10 coins erhalten!");
	      //Coins werden dem Spieler Hinzugefügt (10)
	      CoinsAPI.addCoins(p, Integer.valueOf(10));
	      
	    //Scoreboard wird für denn Spieler gesetzt (p)  
	      Scoreboard_LISTENER.setScoreboard1(p);
	    }
  	
	    if (i == 5) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c5er §6Killstreak!");
	    }
	    if (i == 10) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c10er §6Killstreak!");
	    }
	    if (i == 15) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c15er §6Killstreak!");
	    }
	    if (i == 20) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c20er §6Killstreak!");
	    }
	    if (i == 25) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c25er §6Killstreak!");
	    }
	    if (i == 30) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c30er §6Killstreak!");
	    }
	    if (i == 35) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c35er §6Killstreak!");
	    }
	    if (i == 40) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c40er §6Killstreak!");
	    }
	    if (i == 45) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c45er §6Killstreak!");
	    }
	    if (i == 50) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c50er §6Killstreak!");
	    }
	    if (i == 55) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c55er §6Killstreak!");
	    }
	    if (i == 60) {
	      Bukkit.broadcastMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §e" + p.getName() + " §6hat eine §c60er §6Killstreak!");
	    }
	  }
    
	public void Respawn(final Player player, int Time) {
       Bukkit.getScheduler().runTaskLater(Kill_LISTENER.plugin, new Runnable() {
           public void run() {
           ((CraftPlayer)player).getHandle().playerConnection.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));
           Scoreboard_LISTENER.setScoreboard1(player);
           }
         }, Time);
       }

     }