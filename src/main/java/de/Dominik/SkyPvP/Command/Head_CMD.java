package de.Dominik.SkyPvP.Command;

import de.Dominik.SkyPvP.Main.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Head_CMD implements CommandExecutor {
	
   
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
     Player p = (Player)sender;
     if(!(sender instanceof Player)) {
			sender.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.Konsolen-Sender").replaceAll("&", "§").replaceAll(">", "»"));
			return true;
		}	
     if (p.hasPermission("skypvp.head") || p.hasPermission("skypvp.*") || p.hasPermission("system.*")) {
     if (args.length == 1) {
       ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
       SkullMeta sm = (SkullMeta)skull.getItemMeta();
       sm.setOwner(args[0]);
       skull.setItemMeta(sm);
       p.getInventory().addItem(new ItemStack[] { skull });
       
       p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §7Du hast den Kopf von §e"+args[0] +" §7erhalten");
     } else {
       
       p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §eVerwendung: §7/head <Spieler>");
     }
     
   }else{
	   p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.No-Perm").replaceAll("&", "§").replaceAll(">", "»"));
   }
	return false;
}
}