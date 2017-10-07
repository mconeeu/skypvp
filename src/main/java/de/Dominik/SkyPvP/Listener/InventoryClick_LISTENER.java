package de.Dominik.SkyPvP.Listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.Dominik.SkyPvP.Main.Main;

public class InventoryClick_LISTENER implements Listener {

	ItemStack sword = new ItemStack(Material.STONE_SWORD);
	  ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE);
	  ItemStack sword1 = new ItemStack(Material.DIAMOND_SWORD);
	  
	  @EventHandler
	  public void onClick(InventoryClickEvent e){
	    Player p = (Player)e.getWhoClicked();
	    if(e.getCurrentItem() != null){
	    	try{
		        if (e.getClickedInventory().getTitle().equalsIgnoreCase("§8Wähle dein Kit")){
			  	      e.setCancelled(true);
			  	      if (e.getCurrentItem().getType() == Material.STONE_SWORD){
			  	        ItemStack ss = new ItemStack(Material.STONE_SWORD);
			  	        ItemMeta im = ss.getItemMeta();
			  	        im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			  	        im.addEnchant(Enchantment.DURABILITY, 1, true);
			  	        ss.setItemMeta(im);
			  	        p.getInventory().setItem(0, ss);
			  	        
			  	        ItemStack angel = new ItemStack(Material.FISHING_ROD);
			  	        ItemMeta im1 = angel.getItemMeta();
			  	        im1.addEnchant(Enchantment.DURABILITY, 1, true);
			  	        angel.setItemMeta(im1);
			  	        p.getInventory().setItem(1, angel);
			  	        
			  	        ItemStack food = new ItemStack(Material.COOKED_CHICKEN, 20);
			  	        p.getInventory().setItem(2, food);
			  	        
			  	        ItemStack ga = new ItemStack(Material.GOLDEN_APPLE, 1);
			  	        p.getInventory().setItem(7, ga);
			  	        
			  	        ItemStack ep = new ItemStack(Material.ENDER_PEARL, 16);
			  	        p.getInventory().setItem(8, ep);
			  	        
			  	        ItemStack ch = new ItemStack(Material.CHAINMAIL_HELMET);
			  	        ItemMeta im2 = ch.getItemMeta();
			  	        im2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			  	        im2.addEnchant(Enchantment.DURABILITY, 1, true);
			  	        ch.setItemMeta(im2);
			  	        p.getInventory().setHelmet(ch);
			  	        
			  	        ItemStack cc = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			  	        ItemMeta im3 = cc.getItemMeta();
			  	        im3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			  	        im3.addEnchant(Enchantment.DURABILITY, 1, true);
			  	        cc.setItemMeta(im3);
			  	        p.getInventory().setChestplate(cc);
			  	        
			  	        ItemStack cl = new ItemStack(Material.CHAINMAIL_LEGGINGS);
			  	        ItemMeta im4 = cl.getItemMeta();
			  	        im4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			  	        im4.addEnchant(Enchantment.DURABILITY, 1, true);
			  	        cl.setItemMeta(im4);
			  	        p.getInventory().setLeggings(cl);
			  	        
			  	        ItemStack cb = new ItemStack(Material.CHAINMAIL_BOOTS);
			  	        ItemMeta im5 = cb.getItemMeta();
			  	        im5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			  	        im5.addEnchant(Enchantment.DURABILITY, 1, true);
			  	        cb.setItemMeta(im5);
			  	        p.getInventory().setBoots(cb);
			  	        
			  	        p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §aDu hast das Kit §8Spieler §aausgewählt");
			  	        p.closeInventory();
			  	      }else if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
			  	        if (p.hasPermission("skypvp.kit.diamond") || p.hasPermission("skypvp.*") || p.hasPermission("system.*")){
			  	          ItemStack is = new ItemStack(Material.IRON_SWORD);
			  	          ItemMeta imeta = is.getItemMeta();
			  	          imeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			  	          imeta.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          is.setItemMeta(imeta);
			  	          p.getInventory().setItem(0, is);
			  	          
			  	          ItemStack angel1 = new ItemStack(Material.FISHING_ROD);
			  	          ItemMeta imeta1 = angel1.getItemMeta();
			  	          imeta1.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          angel1.setItemMeta(imeta1);
			  	          p.getInventory().setItem(1, angel1);
			  	          
			  	          ItemStack food1 = new ItemStack(Material.COOKED_CHICKEN, 20);
			  	          p.getInventory().setItem(2, food1);
			  	          
			  	          ItemStack ga1 = new ItemStack(Material.GOLDEN_APPLE, 5);
			  	          p.getInventory().setItem(7, ga1);
			  	          
			  	          ItemStack ep1 = new ItemStack(Material.ENDER_PEARL, 16);
			  	          p.getInventory().setItem(8, ep1);
			  	          
			  	          ItemStack ih = new ItemStack(Material.IRON_HELMET);
			  	          ItemMeta imeta2 = ih.getItemMeta();
			  	          imeta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			  	          imeta2.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          ih.setItemMeta(imeta2);
			  	          p.getInventory().setHelmet(ih);
			  	          
			  	          ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE);
			  	          ItemMeta imeta3 = ic.getItemMeta();
			  	          imeta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			  	          imeta3.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          ic.setItemMeta(imeta3);
			  	          p.getInventory().setChestplate(ic);
			  	          
			  	          ItemStack il = new ItemStack(Material.IRON_LEGGINGS);
			  	          ItemMeta imeta4 = il.getItemMeta();
			  	          imeta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			  	          imeta4.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          il.setItemMeta(imeta4);
			  	          p.getInventory().setLeggings(il);
			  	          
			  	          ItemStack ib = new ItemStack(Material.IRON_BOOTS);
			  	          ItemMeta imeta5 = ib.getItemMeta();
			  	          imeta5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			  	          imeta5.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          ib.setItemMeta(imeta5);
			  	          p.getInventory().setBoots(ib);
			  	          
			  	          p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §aDu hast das Kit §3Diamond §aausgewählt");
			  	          p.closeInventory();
			  	        }
			  	        else
			  	        {
			  	          p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.No-Perm").replaceAll("&", "§").replaceAll(">", "»"));
			  	        }
			  	      }
			  	      else if (e.getCurrentItem().getType() == Material.EMERALD)
			  	      {
			  	        if (p.hasPermission("skypvp.kit.emerald")|| p.hasPermission("skypvp.*") || p.hasPermission("system.*"))
			  	        {
			  	          ItemStack is1 = new ItemStack(Material.IRON_SWORD);
			  	          ItemMeta itemm = is1.getItemMeta();
			  	          itemm.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
			  	          itemm.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          is1.setItemMeta(itemm);
			  	          p.getInventory().setItem(0, is1);
			  	          
			  	          ItemStack angel2 = new ItemStack(Material.FISHING_ROD);
			  	          ItemMeta itemm1 = angel2.getItemMeta();
			  	          itemm1.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          angel2.setItemMeta(itemm1);
			  	          p.getInventory().setItem(1, angel2);
			  	          
			  	          ItemStack food2 = new ItemStack(Material.COOKED_CHICKEN, 20);
			  	          p.getInventory().setItem(2, food2);
			  	          
			  	          ItemStack ga2 = new ItemStack(Material.GOLDEN_APPLE, 8);
			  	          p.getInventory().setItem(7, ga2);
			  	          
			  	          ItemStack ep2 = new ItemStack(Material.ENDER_PEARL, 16);
			  	          p.getInventory().setItem(8, ep2);
			  	          
			  	          ItemStack ih1 = new ItemStack(Material.IRON_HELMET);
			  	          ItemMeta itemm2 = ih1.getItemMeta();
			  	          itemm2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			  	          itemm2.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          ih1.setItemMeta(itemm2);
			  	          p.getInventory().setHelmet(ih1);
			  	          
			  	          ItemStack ic1 = new ItemStack(Material.IRON_CHESTPLATE);
			  	          ItemMeta itemm3 = ic1.getItemMeta();
			  	          itemm3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			  	          itemm3.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          ic1.setItemMeta(itemm3);
			  	          p.getInventory().setChestplate(ic1);
			  	          
			  	          ItemStack il1 = new ItemStack(Material.IRON_LEGGINGS);
			  	          ItemMeta itemm4 = il1.getItemMeta();
			  	          itemm4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			  	          itemm4.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          il1.setItemMeta(itemm4);
			  	          p.getInventory().setLeggings(il1);
			  	          
			  	          ItemStack ib1 = new ItemStack(Material.IRON_BOOTS);
			  	          ItemMeta itemm5 = ib1.getItemMeta();
			  	          itemm5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			  	          itemm5.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          ib1.setItemMeta(itemm5);
			  	          p.getInventory().setBoots(ib1);
			  	          
			  	          p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §aDu hast das Kit §2Emerald §aausgewählt");
			  	          p.closeInventory();
			  	        }else{
			  	          p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.No-Perm").replaceAll("&", "§").replaceAll(">", "»"));
			  	        }
			  	      }else if (e.getCurrentItem().getType() == Material.IRON_INGOT){
			  	        if (p.hasPermission("skypvp.kit.platin") || p.hasPermission("skypvp.*") || p.hasPermission("System.*")){
			  	          ItemStack ds = new ItemStack(Material.DIAMOND_SWORD);
			  	          ItemMeta meta = ds.getItemMeta();
			  	          meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			  	          meta.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          ds.setItemMeta(meta);
			  	          p.getInventory().setItem(0, ds);
			  	          
			  	          ItemStack angel3 = new ItemStack(Material.FISHING_ROD);
			  	          ItemMeta meta1 = angel3.getItemMeta();
			  	          meta1.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          angel3.setItemMeta(meta1);
			  	          p.getInventory().setItem(1, angel3);
			  	          
			  	          ItemStack food3 = new ItemStack(Material.COOKED_CHICKEN, 20);
			  	          p.getInventory().setItem(2, food3);
			  	          
			  	          ItemStack ga3 = new ItemStack(Material.GOLDEN_APPLE, 15);
			  	          p.getInventory().setItem(7, ga3);
			  	          
			  	          ItemStack ep3 = new ItemStack(Material.ENDER_PEARL, 16);
			  	          p.getInventory().setItem(8, ep3);
			  	          
			  	          ItemStack dh = new ItemStack(Material.DIAMOND_HELMET);
			  	          ItemMeta meta2 = dh.getItemMeta();
			  	          meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			  	          meta2.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          dh.setItemMeta(meta2);
			  	          p.getInventory().setHelmet(dh);
			  	          
			  	          ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE);
			  	          ItemMeta meta3 = dc.getItemMeta();
			  	          meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			  	          meta3.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          dc.setItemMeta(meta3);
			  	          p.getInventory().setChestplate(dc);
			  	          
			  	          ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS);
			  	          ItemMeta meta4 = dl.getItemMeta();
			  	          meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			  	          meta4.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          dl.setItemMeta(meta4);
			  	          p.getInventory().setLeggings(dl);
			  	          
			  	          ItemStack db = new ItemStack(Material.DIAMOND_BOOTS);
			  	          ItemMeta meta5 = db.getItemMeta();
			  	          meta5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
			  	          meta5.addEnchant(Enchantment.DURABILITY, 1, true);
			  	          db.setItemMeta(meta5);
			  	          p.getInventory().setBoots(db);
			  	          
			  	          p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §aDu hast das Kit §dPlatin §aausgewählt");
			  	          p.closeInventory();
			  	        }
			  	        else
			  	        {
			  	          p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + Main.cfg.getString("SkyPvP.No-Perm").replaceAll("&", "§").replaceAll(">", "»"));
			  	        }
			  	      }
			  	    }	
	    	}catch (Exception e1){
	    		
	    	}	
	    }
	  }
}
