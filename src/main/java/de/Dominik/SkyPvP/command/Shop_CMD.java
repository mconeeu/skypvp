package de.Dominik.SkyPvP.command;

import de.Dominik.BukkitCoreSystem.util.ItemManager;
import de.Dominik.SkyPvP.inventory.ShopItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Shop_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(sender != null){
            if(cmd.getName().equalsIgnoreCase("shop")){
                Inventory inv = Bukkit.createInventory(p, 27, "§9SkyPvP §8» §cShop");

                for (int i = 0; i <= 26; i++) {
                    inv.setItem(i, ItemManager.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//§oMCONE§8//", true));
                }

                inv.setItem(9, ShopItem.schwerter.getItem());
                inv.setItem(11, ShopItem.boegen.getItem());
                inv.setItem(13, ShopItem.ruestung.getItem());
                inv.setItem(15, ShopItem.extras.getItem());
                inv.setItem(17, ShopItem.spezial.getItem());

                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
            }
        }

        return false;
    }

}
