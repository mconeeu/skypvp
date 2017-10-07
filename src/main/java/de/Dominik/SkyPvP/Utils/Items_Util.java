package de.Dominik.SkyPvP.Utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items_Util implements Listener {
	
public static ItemStack createItem(Material Material, int subid, String Name) {
		
		ItemStack Items = new ItemStack(Material, 1, (short) subid);
		ItemMeta ItemsMeta = Items.getItemMeta();
		ItemsMeta.setDisplayName(Name);
		Items.setItemMeta(ItemsMeta);
		
		return Items;
	}
	
   public static ItemStack createItemLore(Material Material, int subid, String Name, String Lore) {
		
		ItemStack Items = new ItemStack(Material, 1, (short) subid);
		ItemMeta ItemsMeta = Items.getItemMeta();
		ItemsMeta.setDisplayName(Name);
		ArrayList<String> list = new ArrayList<>();
		list.add(Lore);
		ItemsMeta.setLore(list);
		Items.setItemMeta(ItemsMeta);
		
		return Items;
	}
	
	public static ItemStack createEnchantedItem(Material Material, Enchantment Verzauberung, int level, int subid, String Name) {
		
		ItemStack Items = new ItemStack(Material, 1, (short) subid);
		ItemMeta ItemsMeta = Items.getItemMeta();
		ItemsMeta.setDisplayName(Name);
		ItemsMeta.addEnchant(Verzauberung, level, true);
		Items.setItemMeta(ItemsMeta);
		
		return Items;
	}
	public static ItemStack createDoubleEnchantedItem(Material Material, Enchantment Verzauberung, Enchantment Verzauberung2, int level,int level2, int subid, String Name) {
		
		ItemStack Items = new ItemStack(Material, 1, (short) subid);
		ItemMeta ItemsMeta = Items.getItemMeta();
		ItemsMeta.setDisplayName(Name);
		ItemsMeta.addEnchant(Verzauberung, level, true);
		ItemsMeta.addEnchant(Verzauberung2, level2, true);
		Items.setItemMeta(ItemsMeta);
		
		return Items;
	}
	
   public static ItemStack createEnchantedLoreItem(Material Material, Enchantment Verzauberung, int level, int subid, String Name, String Lore) {
		
		ItemStack Items = new ItemStack(Material, 1, (short) subid);
		ItemMeta ItemsMeta = Items.getItemMeta();
		ItemsMeta.setDisplayName(Name);
		ItemsMeta.addEnchant(Verzauberung, level, true);
		ArrayList<String> list = new ArrayList<>();
		list.add(Lore);
		ItemsMeta.setLore(list);
		Items.setItemMeta(ItemsMeta);
		
		return Items;
	}
	
	public static ItemStack createUnbreakableItem(Material Material, int subid, String Name) {
		
		ItemStack Items = new ItemStack(Material, 1, (short) subid);
		ItemMeta ItemsMeta = Items.getItemMeta();
		ItemsMeta.setDisplayName(Name);
		ItemsMeta.spigot().setUnbreakable(true);
		Items.setItemMeta(ItemsMeta);
		
		return Items;
	}
	
	public static ItemStack createAnzahlItem(Material Material, int Anzahl, int subid, String Name){
		
		ItemStack Items = new ItemStack(Material, Anzahl, (short) subid);
		ItemMeta ItemsMeta = Items.getItemMeta();
		ItemsMeta.setDisplayName(Name);
		Items.setItemMeta(ItemsMeta);
		return Items;
		
	}
	
    public static ItemStack createAnzahlLoreItem(Material Material, int Anzahl, int subid, String Name, String Lore){
		
		ItemStack Items = new ItemStack(Material, Anzahl, (short) subid);
		ItemMeta ItemsMeta = Items.getItemMeta();
		ItemsMeta.setDisplayName(Name);
		ArrayList<String> list = new ArrayList<>();
		list.add(Lore);
		ItemsMeta.setLore(list);
		Items.setItemMeta(ItemsMeta);
		return Items;
		
	}

}
