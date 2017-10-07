package de.Dominik.SkyPvP.Listener;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Item_LISTENER implements Listener{
  public static ItemStack createItem(Material material, int anzahl, int subid, String displayname){
    short newsubid = (short)subid;
    ItemStack i = new ItemStack(material, anzahl, newsubid);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(displayname);
    i.setItemMeta(m);
    
    return i;
  }
  
  public static ItemStack createDurability(Material material, int anzahl, int subid, String displayname){
    short neuesubid = (short)subid;
    ItemStack i = new ItemStack(material, anzahl, neuesubid);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(displayname);
    i.setItemMeta(m);
    i.setDurability((short)60);
    
    return i;
  }
  
  public static ItemStack createHeadItem(String owner, String displayname){
    ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    SkullMeta sm = (SkullMeta)i.getItemMeta();
    sm.setOwner(owner);
    sm.setDisplayName(displayname);
    i.setItemMeta(sm);
    
    return i;
  }
  
  public static ItemStack createEnchantment(Material material, int anzahl, int subid, String displayname, Enchantment enchantment, int enchantmentID){
    short neuesubid = (short)subid;
    ItemStack i = new ItemStack(material, anzahl, neuesubid);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(displayname);
    m.addEnchant(enchantment, enchantmentID, true);
    i.setItemMeta(m);
    
    return i;
  }
  
  public static ItemStack createEnchantmentWithLore(Material material, int anzahl, int subid, String displayname, Enchantment enchantment, int enchantmentID, int id){
    short neuesubid = (short)subid;
    ItemStack i = new ItemStack(material, anzahl, neuesubid);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(displayname);
    m.addEnchant(enchantment, enchantmentID, true);
    List<String> lores = new ArrayList();
    lores.add("§7ID: §8" + id);
    m.setLore(lores);
    i.setItemMeta(m);
    
    return i;
  }
  
  public static ItemStack createLeatherBoots(String displayname, Color color, String lores){
    ItemStack i = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta im = (LeatherArmorMeta)i.getItemMeta();
    im.setDisplayName(displayname);
    List<String> lore = new ArrayList();
    lore.add(lores);
    im.setLore(lore);
    im.setColor(color);
    i.setItemMeta(im);
    
    return i;
  }
  
  public static ItemStack createLeatherChest(String displayname, Color color, String lores)
  {
    ItemStack i = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta lam = (LeatherArmorMeta)i.getItemMeta();
    lam.setDisplayName(displayname);
    List<String> lore = new ArrayList();
    lore.add(lores);
    lam.setLore(lore);
    lam.setColor(color);
    i.setItemMeta(lam);
    
    return i;
  }
  
  public static ItemStack createLeatherleggings(String displayname, Color color, String lores)
  {
    ItemStack i = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta lam = (LeatherArmorMeta)i.getItemMeta();
    lam.setDisplayName(displayname);
    List<String> lore = new ArrayList();
    lore.add(lores);
    lam.setLore(lore);
    lam.setColor(color);
    i.setItemMeta(lam);
    
    return i;
  }
  
  public static ItemStack addLore(String Display, Material mat, String lores, int Anzahl)
  {
    ItemStack is = new ItemStack(mat, Anzahl);
    ItemMeta im = is.getItemMeta();
    im.setDisplayName(Display);
    List<String> lore = new ArrayList();
    lore.add(lores);
    im.setLore(lore);
    is.setItemMeta(im);
    return is;
  }
  
  public static ItemStack addLoreLR(String Display, Material id, String info, String RECHTSKLICK, String LINKSKILCK, int Anzahl)
  {
    ItemStack is = new ItemStack(id, Anzahl);
    ItemMeta im = is.getItemMeta();
    im.setDisplayName(Display);
    List<String> lore = new ArrayList();
    lore.add("");
    lore.add(info);
    lore.add("");
    lore.add(LINKSKILCK);
    lore.add(RECHTSKLICK);
    im.setLore(lore);
    is.setItemMeta(im);
    return is;
  }
  
  public static ItemStack addGlow(String Display, Material id, String lores, int Anzahl)
  {
    ItemStack is = new ItemStack(id, Anzahl);
    ItemMeta im = is.getItemMeta();
    im.setDisplayName(Display);
    List<String> lore = new ArrayList();
    lore.add(lores);
    im.setLore(lore);
    im.addEnchant(Enchantment.DURABILITY, 1, true);
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    is.setItemMeta(im);
    return is;
  }
  
  public static ItemStack addGlowLR(String Display, Material id, String info, String RECHTSKLICK, String LINKSKILCK, int Anzahl)
  {
    ItemStack is = new ItemStack(id, Anzahl);
    ItemMeta im = is.getItemMeta();
    im.setDisplayName(Display);
    List<String> lore = new ArrayList();
    lore.add(info);
    lore.add("");
    lore.add(LINKSKILCK);
    lore.add(RECHTSKLICK);
    im.setLore(lore);
    im.addEnchant(Enchantment.DURABILITY, 1, true);
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    is.setItemMeta(im);
    return is;
  }
  
  public static ItemStack addGlowSUBID(String Display, Material mat, int Anzahl, int subID)
  {
    ItemStack is = new ItemStack(mat, Anzahl, (short)subID);
    ItemMeta im = is.getItemMeta();
    im.setDisplayName(Display);
    im.addEnchant(Enchantment.DURABILITY, 1, true);
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    is.setItemMeta(im);
    return is;
  }
  
  public static ItemStack Skull(String Display, Material m, String lores, int Anzahl, short Shorts, String Owner)
  {
    ItemStack is = new ItemStack(m, Anzahl, (short)3);
    SkullMeta im = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
    im.setOwner(Owner);
    im.setDisplayName(Display);
    List<String> lore = new ArrayList();
    lore.add(lores);
    im.setLore(lore);
    is.setItemMeta(im);
    return is;
  }
  
  public static ItemStack coloredArmor(String Display, Material m, String lores, int Anzahl, short Shorts, int RGB1, int RGB2, int RGB3)
  {
    ItemStack istack52 = new ItemStack(m, Anzahl, Shorts);
    LeatherArmorMeta istackMeta52 = (LeatherArmorMeta)istack52.getItemMeta();
    istackMeta52.setColor(Color.fromRGB(RGB1, RGB2, RGB3));
    istackMeta52.setDisplayName(Display);
    List<String> lore = new ArrayList();
    lore.add(lores);
    istackMeta52.setLore(lore);
    istack52.setItemMeta(istackMeta52);
    return istack52;
  }
}
