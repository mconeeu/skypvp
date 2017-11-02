package de.Dominik.SkyPvP.command;

import de.Dominik.BukkitCoreSystem.util.ItemManager;
import de.Dominik.SkyPvP.Main;
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
		Player p = (Player)sender;

		if(sender == null) {
			Bukkit.getConsoleSender().sendMessage(Main.config.getConfigValue("System-Prefix") + Main.config.getConfigValue("System-Konsolen-Sender"));
			return true;
		} else if (cmd.getName().equalsIgnoreCase("kit") || cmd.getName().equalsIgnoreCase("kits")) {
		    if (args.length == 0){
				Inventory inv = Bukkit.getServer().createInventory(null, 27, "§8Wähle dein Kit");

                for (int i = 0; i <= 26; i++) {
                    inv.setItem(i, ItemManager.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
                }

				inv.setItem(10, ItemManager.createItem(Material.STONE_SWORD, 0, 1, "§7Kit §8Spieler", true));
				inv.setItem(12, ItemManager.createItem(Material.DIAMOND_SWORD, 0, 1, "§7Kit §3Diamond", true));
                inv.setItem(14, ItemManager.createItem(Material.EMERALD, 0, 1, "§7Kit §2Emerald", true));
                inv.setItem(16, ItemManager.createItem(Material.IRON_INGOT, 0, 1, "§7Kit §dPlatin", true));

                p.openInventory(inv);
		    } else {
		        p.sendMessage(Main.config.getConfigValue("System-Prefix") + "§cBitte nutze den Command /kit");
		    }

		    return false;
        }

		return false;
	}
}