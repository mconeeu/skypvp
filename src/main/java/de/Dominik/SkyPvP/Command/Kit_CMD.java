package de.Dominik.SkyPvP.Command;

import de.Dominik.SkyPvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;


public class Kit_CMD implements CommandExecutor {
private Plugin plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.Konsolen-Sender").replaceAll("&", "§").replaceAll(">", "»"));
			return true;
		}	
		if(cmd.getName().equalsIgnoreCase("kit")) {
	       
			Player p = (Player)sender;
		    if (args.length == 0){
		      ItemStack i = new ItemStack(Material.STONE_SWORD);
		      ItemMeta im = i.getItemMeta();
		      im.setDisplayName("§7Kit §8Spieler");
		      i.setItemMeta(im);
		      
		      ItemStack i2 = new ItemStack(Material.DIAMOND_SWORD);
		      ItemMeta im2 = i2.getItemMeta();
		      im2.setDisplayName("§7Kit §3Diamond");
		      i2.setItemMeta(im2);
		      
		      ItemStack i3 = new ItemStack(Material.EMERALD);
		      ItemMeta im3 = i3.getItemMeta();
		      im3.setDisplayName("§7Kit §2Emerald");
		      i3.setItemMeta(im3);
		      
		      ItemStack i4 = new ItemStack(Material.IRON_INGOT);
		      ItemMeta im4 = i4.getItemMeta();
		      im4.setDisplayName("§7Kit §dPlatin");
		      i4.setItemMeta(im4);
		      
		      Inventory inv = Bukkit.getServer().createInventory(null, 27, "§8Wähle dein Kit");
		      
		      inv.setItem(10, i);
		      inv.setItem(12, i2);
		      inv.setItem(14, i3);
		      inv.setItem(16, i4);
		      
		      p.openInventory(inv);
		    }
		    else
		    {
		      p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §cBitte nutze den Command /kit");
		    }
		    return false;
		  }
		return false;
	}
}