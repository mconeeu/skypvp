package me.SkyPvP.Command.de;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import me.SkyPvP.Main.de.Main;

public class SetSpawnShop_CMD implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args){
	    Player p = (Player)sender;
	    if(!(sender instanceof Player)) {
			sender.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.Konsolen-Sender").replaceAll("&", "§").replaceAll(">", "»"));
			return true;
		}	
	    if ((sender.hasPermission("skypvp.setshop") || sender.hasPermission("skypvp.*") || sender.hasPermission("system.*")) && 
	      (cmd.getName().equalsIgnoreCase("setspawnshop")) && 
	      (args.length == 0)){
	      Villager v = (Villager)p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
	      v.setCustomName("§9SkyPvP §8» §cShop");
	      v.setCustomNameVisible(true);
	      //v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 999999999));
	      //v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 999999999, 999999999));
	      //v.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 999999999));
	      v.setCanPickupItems(false);
	      v.setNoDamageTicks(0);
	      v.damage(0.0D);
	      v.setFireTicks(0);
	    }else{
	    	p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.No-Perm").replaceAll("&", "§").replaceAll(">", "»"));
	    }
	    return false;
	  }

}
