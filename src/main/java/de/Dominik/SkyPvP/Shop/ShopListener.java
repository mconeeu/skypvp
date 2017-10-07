package me.SkyPvP.Shop.de;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import de.Dominik.BukkitCoreSystem.API.CoinsAPI;
import me.SkyPvP.API.de.API;
import me.SkyPvP.Listener.de.Scoreboard_LISTENER;
import me.SkyPvP.Main.de.Main;


public class ShopListener implements Listener{
	
	@EventHandler
	public void onShopLister(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		
		Inventory waffengui = Bukkit.createInventory(p, 27, "§e§lShop §8§ §cWaffen");
		Inventory boegengui = Bukkit.createInventory(p, 27, "§e§lShop §8§ §cBögen");
		Inventory ruestunggui = Bukkit.createInventory(p, 36, "§e§lShop §8§ §cRüstung");
		Inventory extragui = Bukkit.createInventory(p, 27, "§e§lShop §8§ §cExtras");
		Inventory spezialgui = Bukkit.createInventory(p, 27, "§e§lShop §8§ §cSpezial");
		
		if(e.getCurrentItem() != null){
			try{
				if(e.getInventory().getName().equalsIgnoreCase("§9SkyPvP §8» §cShop")){
					e.setCancelled(true);
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchwerter")){
						
						waffengui.setItem(9, ShopItems.schwert1());
						waffengui.setItem(11, ShopItems.schwert2());
						waffengui.setItem(13, ShopItems.schwert3());
						waffengui.setItem(15, ShopItems.schwert4());
						waffengui.setItem(17, ShopItems.schwert5());
						
						p.openInventory(waffengui);
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBögen")){
						
						boegengui.setItem(9, ShopItems.boegen1());
						boegengui.setItem(11, ShopItems.boegen2());
						boegengui.setItem(13, ShopItems.boegen3());
						boegengui.setItem(15, ShopItems.boegen4());
						boegengui.setItem(17, ShopItems.boegen5());
						
						p.openInventory(boegengui);
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRüstung")){
						
						ruestunggui.setItem(2, ShopItems.helm1());
						ruestunggui.setItem(3, ShopItems.helm2());
						ruestunggui.setItem(4, ShopItems.helm3());
						ruestunggui.setItem(5, ShopItems.helm4());
						
						ruestunggui.setItem(11, ShopItems.brust1());
						ruestunggui.setItem(12, ShopItems.brust2());
						ruestunggui.setItem(13, ShopItems.brust3());
						ruestunggui.setItem(14, ShopItems.brust4());
						
						ruestunggui.setItem(20, ShopItems.hose1());
						ruestunggui.setItem(21, ShopItems.hose2());
						ruestunggui.setItem(22, ShopItems.hose3());
						ruestunggui.setItem(23, ShopItems.hose4());
						
						ruestunggui.setItem(29, ShopItems.schuhe1());
						ruestunggui.setItem(30, ShopItems.schuhe2());
						ruestunggui.setItem(31, ShopItems.schuhe3());
						ruestunggui.setItem(32, ShopItems.schuhe4());
						
						p.openInventory(ruestunggui);
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cExtras")){
						
						extragui.setItem(9, ShopItems.op1());
						extragui.setItem(11, ShopItems.op2());
						extragui.setItem(13, ShopItems.op3());
						extragui.setItem(15, ShopItems.op4());
						extragui.setItem(17, ShopItems.op5());
						
						p.openInventory(extragui);
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSpezial")){
						
						spezialgui.setItem(10, ShopItems.axt1());
						spezialgui.setItem(13, ShopItems.soup());
						spezialgui.setItem(16, ShopItems.axt2());
						
						p.openInventory(spezialgui);
						
					} 
				}
				
				/* Schwerter */
				if(e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cWaffen")){
					e.setCancelled(true);
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchwert 1")){
						 int coins = CoinsAPI.getCoins(p) - 10;
					        if (coins <= -1){
					        	p.closeInventory();
								API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
								API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
								Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, Integer.valueOf(10));
							p.getInventory().addItem(ShopItems.schwert1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSchwert 1 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);

						}
				        
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchwert 2")){
						int coins = CoinsAPI.getCoins(p) - 15;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							
							CoinsAPI.removeCoins(p, 15);
							p.getInventory().addItem(ShopItems.schwert2());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSchwert 2 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
				        
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchwert 3")){
						int coins = CoinsAPI.getCoins(p) - 20;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 20);
							p.getInventory().addItem(ShopItems.schwert3());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSchwert 3 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchwert 4")){
						int coins = CoinsAPI.getCoins(p) - 50;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 50);
							p.getInventory().addItem(ShopItems.schwert1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSchwert 4 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchwert 5")){
						int coins = CoinsAPI.getCoins(p) - 100;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 100);
							p.getInventory().addItem(ShopItems.schwert5());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSchwert 5 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
					}
					
				} else if(e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cBögen")){
					e.setCancelled(true);
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBogen 1")){
						int coins = CoinsAPI.getCoins(p) - 10;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 10);
							p.getInventory().addItem(ShopItems.boegen1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eBogen 1 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBogen 2")){
						int coins = CoinsAPI.getCoins(p) - 15;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 15);
							p.getInventory().addItem(ShopItems.boegen2());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eBogen 2 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBogen 3")){
						int coins = CoinsAPI.getCoins(p) - 25;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 25);
							p.getInventory().addItem(ShopItems.boegen1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eBogen 3 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBogen 4")){
						int coins = CoinsAPI.getCoins(p) - 50;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "v"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 50);
							p.getInventory().addItem(ShopItems.boegen4());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eBogen 5 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBogen 5")){
						int coins = CoinsAPI.getCoins(p) - 100;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 100);
							p.getInventory().addItem(ShopItems.boegen5());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eBogen 5 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
					}
					
				} else if(e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cRüstung")){
					e.setCancelled(true);
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHelm 1")){
						int coins = CoinsAPI.getCoins(p) - 10;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 10);
							p.getInventory().addItem(ShopItems.helm1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eHelm 1 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHelm 2")){
						int coins = CoinsAPI.getCoins(p) - 25;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 25);
							p.getInventory().addItem(ShopItems.helm2());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eHelm 2 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHelm 3")){
						int coins = CoinsAPI.getCoins(p) - 50;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 50);
							p.getInventory().addItem(ShopItems.helm3());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eHelm 3 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
					
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHelm 4")){
						int coins = CoinsAPI.getCoins(p) - 100;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 100);
							p.getInventory().addItem(ShopItems.helm4());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eHelm 4 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
						
						}
						
					}  else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBrust 1")){
						int coins = CoinsAPI.getCoins(p) - 10;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 10);
							p.getInventory().addItem(ShopItems.brust1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eBrust 1 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBrust 2")){
						int coins = CoinsAPI.getCoins(p) - 25;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 25);
							p.getInventory().addItem(ShopItems.brust2());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eBrust 2 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBrust 3")){
						int coins = CoinsAPI.getCoins(p) - 50;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 50);
							p.getInventory().addItem(ShopItems.brust3());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eBrust 3 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
						
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBrust 4")){
						int coins = CoinsAPI.getCoins(p) - 100;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 100);
							p.getInventory().addItem(ShopItems.brust4());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eBrust 4 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHose 1")){
						int coins = CoinsAPI.getCoins(p) - 10;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 10);
							p.getInventory().addItem(ShopItems.hose1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eHose 1 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHose 2")){
						int coins = CoinsAPI.getCoins(p) - 25;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 25);
							p.getInventory().addItem(ShopItems.hose2());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eHose 2 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
						
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHose 3")){
						int coins = CoinsAPI.getCoins(p) - 50;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 50);
							p.getInventory().addItem(ShopItems.hose3());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eHose 3 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHose 4")){
						int coins = CoinsAPI.getCoins(p) - 100;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 100);
							p.getInventory().addItem(ShopItems.hose4());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eHose 4 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
						
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchuhe 1")){
						int coins = CoinsAPI.getCoins(p) - 10;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {

							CoinsAPI.removeCoins(p, 10);
							p.getInventory().addItem(ShopItems.schuhe1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSchuhe 1 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchuhe 2")){
						int coins = CoinsAPI.getCoins(p) - 25;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 25);
							p.getInventory().addItem(ShopItems.schuhe2());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSchuhe 2 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchuhe 3")){
						int coins = CoinsAPI.getCoins(p) - 50;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 60);
							p.getInventory().addItem(ShopItems.schuhe3());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSchuhe 3 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchuhe 4")){
						int coins = CoinsAPI.getCoins(p) - 100;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 100);
							p.getInventory().addItem(ShopItems.schuhe4());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSchuhe 4 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
					}
					
				} else if(e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cExtras")){
					e.setCancelled(true);
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c10 OP-Äpfel")){
						int coins = CoinsAPI.getCoins(p) - 50;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 50);
							p.getInventory().addItem(ShopItems.op1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §e10 OP-§pfel §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c15 OP-Äpfel")){
						int coins = CoinsAPI.getCoins(p) - 75;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 75);
							p.getInventory().addItem(ShopItems.op2());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §e15 OP-§pfel §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c20 OP-Äpfel")){
						int coins = CoinsAPI.getCoins(p) - 100;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 100);
							p.getInventory().addItem(ShopItems.op3());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §e20 OP-§pfel §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c25 OP-Äpfel")){
						int coins = CoinsAPI.getCoins(p) - 125;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 125);
							p.getInventory().addItem(ShopItems.op4());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §e25 OP-§pfel §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c30 OP-Äpfel")){
						int coins = CoinsAPI.getCoins(p) - 150;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 150);
							p.getInventory().addItem(ShopItems.op5());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §e30 OP-§pfel §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
					}
					
				} else if(e.getInventory().getName().equalsIgnoreCase("§e§lShop §8§ §cSpezial")){
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAxt 1")){
						int coins = CoinsAPI.getCoins(p) - 50;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 50);
							p.getInventory().addItem(ShopItems.axt1());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eAxt 1 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAxt 2")){
						int coins = CoinsAPI.getCoins(p) - 100;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 100);
							p.getInventory().addItem(ShopItems.axt2());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eAxt 2 §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
						
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSoup")){
						int coins = CoinsAPI.getCoins(p) - 250;
				        if (coins <= -1){
				        	p.closeInventory();
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Dafür hast du nicht genung §eCoins!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
						} else {
							CoinsAPI.removeCoins(p, 250);
							p.getInventory().addItem(ShopItems.soup());
							API.sendTitle(p, Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»"), 25, 25, 25);
							API.sendSubTitle(p, "§7Du hast das Item §eSoup §7gekauft!", 25, 25, 25);
							Scoreboard_LISTENER.setScoreboard1(p);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
							
						}
					}
				}
			}catch (Exception e1){
				
			}
		  }
		}
		
	}

