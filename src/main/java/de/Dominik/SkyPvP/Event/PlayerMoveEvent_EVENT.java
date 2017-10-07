package me.SkyPvP.Event.de;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.SkyPvP.Listener.de.Listener_LISTENER;
import me.SkyPvP.Main.de.Main;

public class PlayerMoveEvent_EVENT implements Listener{

	@EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location loc1 = p.getLocation();
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        Location loc = new Location(p.getLocation().getWorld(), x, y, z);
        if (loc.subtract(0.0, 0.5, 0.0).getBlock().getType().equals((Object)Material.SPONGE)) {
            Vector v = p.getLocation().getDirection().multiply(1.5).setY(1.2);
            p.setVelocity(v);
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 3.0f, 2.0f);
            p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 2);
        }
        if (loc1.getY() < 0.0) {
            e.getPlayer().damage(20.0);
        }
    }
	
	 @EventHandler
	  public void onMoveSpawn(PlayerMoveEvent e){
	    Player p = e.getPlayer();
	    if (Listener_LISTENER.cooldownlist.contains(p)){
	    	Listener_LISTENER.cooldownlist.remove(p);
	      p.sendMessage(Main.cfg.getString("SkyPvP.Server-Prefix").replaceAll("&", "§").replaceAll(">", "»") + " §4Du hast dich bewegt! Teleportation abgebrochen");
	    }
	  }
}
