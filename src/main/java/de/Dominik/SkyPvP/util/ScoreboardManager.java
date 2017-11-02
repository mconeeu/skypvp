package de.Dominik.SkyPvP.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import de.Dominik.BukkitCoreSystem.api.CoinsAPI;
import de.Dominik.SkyPvP.Main;

import java.util.UUID;

import static de.Dominik.BukkitCoreSystem.Main.statsSkypvp;

public class ScoreboardManager {

	public ScoreboardManager() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                final Scoreboard board = p.getScoreboard();
                final Objective old = board.getObjective(DisplaySlot.SIDEBAR);

                setScoreboard(p);
                old.unregister();
            }
        }, 20, 20);
	}

    public static void setScoreboard(Player p) {
  	   
		int kills = statsSkypvp.getKills(p.getUniqueId().toString(), p.getName());
		int tode = statsSkypvp.getDeaths(p.getUniqueId().toString(), p.getName());
		int coins = CoinsAPI.getCoins(p);

		final Scoreboard board = p.getScoreboard();
		final Objective o = board.registerNewObjective(UUID.randomUUID().toString().substring(0,16), "Skypvp");

		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(Main.config.getConfigValue("ScoreBoard-1"));

		o.getScore(Main.config.getConfigValue("ScoreBoard-2")).setScore(11);
		o.getScore(Main.config.getConfigValue("ScoreBoard-3")+ kills).setScore(10);
		o.getScore(ChatColor.GOLD.toString()).setScore(9);
		o.getScore(Main.config.getConfigValue("ScoreBoard-4")).setScore(8);
		o.getScore(Main.config.getConfigValue("ScoreBoard-5") + tode).setScore(7);
		o.getScore(ChatColor.YELLOW.toString()).setScore(6);
		o.getScore(Main.config.getConfigValue("ScoreBoard-6")).setScore(5);
		o.getScore(Main.config.getConfigValue("ScoreBoard-7")+ coins).setScore(4);
		o.getScore(ChatColor.BLUE.toString()).setScore(3);
		o.getScore(Main.config.getConfigValue("ScoreBoard-8")).setScore(2);
		o.getScore(Main.config.getConfigValue("ScoreBoard-9")).setScore(1);
		o.getScore(ChatColor.GREEN.toString()).setScore(0);

		p.setScoreboard(board);
     }
			
}