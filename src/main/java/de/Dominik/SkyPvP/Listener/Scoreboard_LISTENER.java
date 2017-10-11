package de.Dominik.SkyPvP.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.Dominik.BukkitCoreSystem.API.CoinsAPI;
import de.Dominik.SkyPvP.Main.Main;

import static de.Dominik.BukkitCoreSystem.Main.Main.statsSkypvp;

public class Scoreboard_LISTENER implements Listener {
	
    public static void setScoreboard1(Player p) {
  	   
  	   int kills = statsSkypvp.getKills(p.getUniqueId().toString(), p.getName());
  	   int tode = statsSkypvp.getDeaths(p.getUniqueId().toString(), p.getName());
  	   int coins = CoinsAPI.getCoins(p);

       Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
      
       Objective ob = board.registerNewObjective("SkyPvP", "System");
       ob.setDisplaySlot(DisplaySlot.SIDEBAR);
       ob.setDisplayName(Main.cfg.getString("SkyPvP.ScoreBoard-1").replaceAll("&", "§").replaceAll(">", "»"));
       Score s14 = ob.getScore(Main.cfg.getString("SkyPvP.ScoreBoard-2").replaceAll("&", "§").replaceAll(">", "»"));
       Score s13 = ob.getScore(Main.cfg.getString("SkyPvP.ScoreBoard-3").replaceAll("&", "§").replaceAll(">", "»")+ kills);
       Score s12 = ob.getScore(ChatColor.GOLD.toString());
       Score s11 = ob.getScore(Main.cfg.getString("SkyPvP.ScoreBoard-4").replaceAll("&", "§").replaceAll(">", "»"));
       Score s10 = ob.getScore(Main.cfg.getString("SkyPvP.ScoreBoard-5").replaceAll("&", "§").replaceAll(">", "»") + tode);
       Score s9 = ob.getScore(ChatColor.YELLOW.toString());
       Score s8 = ob.getScore(Main.cfg.getString("SkyPvP.ScoreBoard-6").replaceAll("&", "§").replaceAll(">", "»"));
       Score s7 = ob.getScore(Main.cfg.getString("SkyPvP.ScoreBoard-7").replaceAll("&", "§").replaceAll(">", "»")+ coins);
       Score s6 = ob.getScore(ChatColor.BLUE.toString());
       Score s5 = ob.getScore(Main.cfg.getString("SkyPvP.ScoreBoard-8").replaceAll("&", "§").replaceAll(">", "»"));
       Score s4 = ob.getScore(Main.cfg.getString("SkyPvP.ScoreBoard-9").replaceAll("&", "§").replaceAll(">", "»"));
       Score s3 = ob.getScore(ChatColor.GREEN.toString());
       
       
       s14.setScore(16);
       s13.setScore(15);
       s12.setScore(14);
       s11.setScore(13);
       s10.setScore(12);
       s9.setScore(11);
       s8.setScore(10);
       s7.setScore(9);
       s6.setScore(8);
       s5.setScore(7);
       s4.setScore(6);
       s3.setScore(5);
       
		p.setScoreboard(board);
		
		Team SV = board.registerNewTeam("01300SV");
		Team Spieler = board.registerNewTeam("01200SPIELER");
		Team Premium = board.registerNewTeam("01100PREMIUM");
		Team PremiumPlus = board.registerNewTeam("01000PREMIUMPLUS");
		Team YouTuber = board.registerNewTeam("00900YT");
		Team Team = board.registerNewTeam("00800TEAM");
		Team Supporter = board.registerNewTeam("00700SUP");
		Team Moderator = board.registerNewTeam("00400MOD");
		Team SrModerator = board.registerNewTeam("00300SRMOD");
		Team JrBuilder = board.registerNewTeam("00600JRSUPP");
		Team Builder = board.registerNewTeam("00500BUILDER");
		Team Developer = board.registerNewTeam("00200DEV");
		Team Admin = board.registerNewTeam("00100ADMIN");
		
		/**
		 * [TablistManager] SetPrefix 
		 */
		
		Admin.setPrefix(Main.cfg.getString("GameAPI-Tablist-Admin").replaceAll("&", "§").replaceAll(">>", "»"));
		Developer.setPrefix(Main.cfg.getString("GameAPI-Tablist-Developer").replaceAll("&", "§").replaceAll(">>", "»"));
		Builder.setPrefix(Main.cfg.getString("GameAPI-Tablist-Builder").replaceAll("&", "§").replaceAll(">>", "»"));
		JrBuilder.setPrefix(Main.cfg.getString("GameAPI-Tablist-JrSupporter").replaceAll("&", "§").replaceAll(">>", "»"));
		SrModerator.setPrefix(Main.cfg.getString("GameAPI-Tablist-SrModerator").replaceAll("&", "§").replaceAll(">>", "»"));
		Moderator.setPrefix(Main.cfg.getString("GameAPI-Tablist-Moderator").replaceAll("&", "§").replaceAll(">>", "»"));
		Supporter.setPrefix(Main.cfg.getString("GameAPI-Tablist-Supporter").replaceAll("&", "§").replaceAll(">>", "»"));
		Team.setPrefix(Main.cfg.getString("GameAPI-Tablist-Team").replaceAll("&", "§").replaceAll(">>", "»"));
		YouTuber.setPrefix(Main.cfg.getString("GameAPI-Tablist-YouTuber").replaceAll("&", "§").replaceAll(">>", "»"));
		PremiumPlus.setPrefix(Main.cfg.getString("GameAPI-Tablist-Premium+").replaceAll("&", "§").replaceAll(">>", "»"));
		Premium.setPrefix(Main.cfg.getString("GameAPI-Tablist-Premium").replaceAll("&", "§").replaceAll(">>", "»"));
		Spieler.setPrefix(Main.cfg.getString("GameAPI-Tablist-Spieler").replaceAll("&", "§").replaceAll(">>", "»"));
		SV.setPrefix(Main.cfg.getString("GameAPI-Tablist-Spielverderber").replaceAll("&", "§").replaceAll(">>", "»"));
		
		Bukkit.getOnlinePlayers().forEach(Player ->{
			if(Player.hasPermission("group.Admin")){
				Admin.addEntry(Player.getName());
			}else if(Player.hasPermission("group.Developer")){
				Developer.addEntry(Player.getName());
			}else if(Player.hasPermission("group.Builder")){
				Builder.addEntry(Player.getName());
			}else if(Player.hasPermission("group.JrSupporter")){
				JrBuilder.addEntry(Player.getName());
			}else if(Player.hasPermission("group.SrModerator")){
				SrModerator.addEntry(Player.getName());
			}else if(Player.hasPermission("group.Moderator")){
				Moderator.addEntry(Player.getName());
			}else if(Player.hasPermission("group.Supporter")){
				Supporter.addEntry(Player.getName());
			}else if(Player.hasPermission("group.Team")){
				Team.addEntry(Player.getName());
			}else if(Player.hasPermission("group.YouTuber")){
				YouTuber.addEntry(Player.getName());
			}else if(Player.hasPermission("group.Premium+")){
				PremiumPlus.addEntry(Player.getName());
			}else if(Player.hasPermission("group.Premium")){
				Premium.addEntry(Player.getName());
			}else if(Player.hasPermission("group.Spieler")){
				Spieler.addEntry(Player.getName());
			}else if(Player.hasPermission("group.Spielverderber")){
				SV.addEntry(Player.getName());
			}
			p.setScoreboard(board);
		});
     }
			
}