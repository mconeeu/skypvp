package de.Dominik.SkyPvP.Shop;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopItems {

	/* Schwerter */
	public static ItemStack schwerter() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cSchwerter");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Abteil mit Schwertern.");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack schwert1() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cSchwert 1");
	   	ArrayList<String> lore = new ArrayList<>();
	   	meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	   	lore.add("§8» §7Kosten: §e10 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack schwert2() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cSchwert 2");
	   	ArrayList<String> lore = new ArrayList<>();
	   	meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
	   	lore.add("§8» §7Kosten: §e15 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack schwert3() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cSchwert 3");
	   	ArrayList<String> lore = new ArrayList<>();
	   	meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 1, true);
	   	meta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
	   	lore.add("§8» §7Kosten: §e20 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack schwert4() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cSchwert 4");
	   	ArrayList<String> lore = new ArrayList<>();
	   	meta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 2, true);
	   	meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
	   	lore.add("§8» §7Kosten: §e50 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack schwert5() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cSchwert 5");
	   	ArrayList<String> lore = new ArrayList<>();
	   	meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 3, true);
	   	meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
	   	lore.add("§8» §7Kosten: §e100 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	/* B§gen */
	public static ItemStack boegen() { 
	   	ItemStack item = new ItemStack(Material.BOW, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBögen");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Abteil mit Bögen.");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack boegen1() { 
	   	ItemStack item = new ItemStack(Material.BOW, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBogen 1");
	   	meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e10 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack boegen2() { 
	   	ItemStack item = new ItemStack(Material.BOW, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBogen 2");
	   	meta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e15 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack boegen3() { 
	   	ItemStack item = new ItemStack(Material.BOW, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBogen 3");
	   	meta.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
	   	meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
	   	meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 1, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e25 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack boegen4() { 
	   	ItemStack item = new ItemStack(Material.BOW, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBogen 4");
	   	meta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
	   	meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
	   	meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e50 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack boegen5() { 
	   	ItemStack item = new ItemStack(Material.BOW, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBogen 5");
	   	meta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
	   	meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
	   	meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e100 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	/* R§stung*/
	public static ItemStack ruestung() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cRüstung");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Abteil mit Rüstung.");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	/*R§stung Helme */
	public static ItemStack helm1() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_HELMET, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cHelm 1");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e10 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack helm2() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_HELMET, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cHelm 2");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e20 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack helm3() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_HELMET, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cHelm 3");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e50 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack helm4() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_HELMET, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cHelm 4");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 3, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e100 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	/* R§stung Br§ste*/
	public static ItemStack brust1() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBrust 1");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e10 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack brust2() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBrust 2");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e20 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack brust3() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBrust 3");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e50 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack brust4() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cBrust 4");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 3, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e100 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	/* R§stung Hosen */
	
	public static ItemStack hose1() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cHose 1");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e10 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack hose2() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cHose 2");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e20 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack hose3() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cHose 3");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e50 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack hose4() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cHose 4");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 3, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e100 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	/* R§stung Schuhe */
	public static ItemStack schuhe1() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cschuhe 1");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e10 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack schuhe2() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cschuhe 2");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e20 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack schuhe3() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cschuhe 3");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e50 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack schuhe4() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cschuhe 4");
	   	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	   	meta.addEnchant(Enchantment.DURABILITY, 3, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e100 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	
	/* Extras */
	public static ItemStack extras() { 
	   	ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cExtras");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Abteil mit Extras items.");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack op1() { 
	   	ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 10, (short) 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§c10 OP-Äpfel");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e50 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack op2() { 
	   	ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 15, (short) 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§c15 OP-Äpfel");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e75 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack op3() { 
	   	ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 20, (short) 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§c20 OP-Äpfel");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8v §7Kosten: §e100 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack op4() { 
	   	ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 25, (short) 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§c25 OP-Äpfel");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e125 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack op5() { 
	   	ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 30, (short) 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§c30 OP-Äpfel");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e150 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	
	
	/* Spezial */
	public static ItemStack spezial() { 
	   	ItemStack item = new ItemStack(Material.TNT, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cSpezial");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Abteil mit Spezial items.");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack axt1() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_AXE, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cAxt 1");
	   	ArrayList<String> lore = new ArrayList<>();
	   	meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
	   	lore.add("§8» §7Kosten: §e50 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack axt2() { 
	   	ItemStack item = new ItemStack(Material.DIAMOND_AXE, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cAxt 2");
	   	meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
	   	meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e100 Coins");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	
	public static ItemStack soup() { 
	   	ItemStack item = new ItemStack(Material.MUSHROOM_SOUP, 1);
	   	ItemMeta meta = item.getItemMeta();
	   	meta.setDisplayName("§cSoup");
	   	ArrayList<String> lore = new ArrayList<>();
	   	lore.add("§8» §7Kosten: §e250 Coins§7, mit dieser Suppe kannst du dich heilen!");
	   	meta.setLore(lore);
	   	item.setItemMeta(meta);

	   	return item;
	   }
	

	
}
