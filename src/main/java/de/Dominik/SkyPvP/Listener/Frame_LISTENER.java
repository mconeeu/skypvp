package de.Dominik.SkyPvP.Listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.Dominik.SkyPvP.Main.Main;

public class Frame_LISTENER implements Listener{
  String glas = "§a";
  
  @EventHandler
  public void on(PlayerInteractEntityEvent e){
    Entity en = e.getRightClicked();
    Player p = e.getPlayer();
        if ((en instanceof ItemFrame)){
            ItemFrame itemframe = (ItemFrame)en;
            if ((itemframe.getItem().getType() == Material.AIR) || (itemframe.getItem() == null)) {
            	e.setCancelled(false);
              return;
            }
            openInventory(p, itemframe.getItem(), 10);	
          }	
  }
  
  @EventHandler
  public void on(InventoryClickEvent e){
    try{
      if ((e.getInventory().getName().equalsIgnoreCase(Main.cfg.getString("SkyPvP.ItemFrame").replaceAll("&", "§").replaceAll(">", "»"))) && 
        (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.glas))) {
        e.setCancelled(true);
      }
    }catch (NullPointerException localNullPointerException) {}
  }
  
  @EventHandler
  public void on(EntityDamageByEntityEvent e){
    Entity en = e.getEntity();
    Entity damager = e.getDamager();
    if (((en instanceof ItemFrame)) && ((damager instanceof Player))){
      Player p = (Player)e.getDamager();
      if (p.hasPermission("SkyPvP.Removeframe") || p.hasPermission("SkyPvP.*") || p.hasPermission("System.*")){
        e.setCancelled(false);
        return;
      }else{
    	  e.setCancelled(true);
      }
      
      if (((en instanceof ItemFrame)) && e.getDamager() instanceof Projectile) {
          Projectile x = (Projectile) e.getDamager();
          if (x.getType() == EntityType.FISHING_HOOK) {
              e.setCancelled(true);
            }
          }
      
      if (((en instanceof ItemFrame)) && e.getDamager() instanceof Entity) {
          Projectile x = (Projectile) e.getDamager();
          if (x.getType() == EntityType.ARROW) {
              e.setCancelled(true);
            }
          }
    }
  }
  
  private void openInventory(Player p, ItemStack item, int anzahl){
    Inventory inv = Bukkit.createInventory(null, 27, Main.cfg.getString("SkyPvP.ItemFrame").replaceAll("&", "§").replaceAll(">", "»"));
    if (item.getMaxStackSize() > 1) {
      item.setAmount(anzahl);
    }
    inv.setItem(13, item);
    p.openInventory(inv);
  }
}
