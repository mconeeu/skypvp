package me.SkyPvP.Shop.de;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Shop implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Inventory shopgui = Bukkit.createInventory(p, 27, "§9SkyPvP §8» §cShop");
		if(sender instanceof Player){
			if(cmd.getName().equalsIgnoreCase("shop")){
				
				shopgui.setItem(9, ShopItems.schwerter());
				shopgui.setItem(11, ShopItems.boegen());
				shopgui.setItem(13, ShopItems.ruestung());
				shopgui.setItem(15, ShopItems.extras());
				shopgui.setItem(17, ShopItems.spezial());
				
				p.openInventory(shopgui);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
			}
		}
		
		return false;
	}

}