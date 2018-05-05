/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class PlayerBedEnter implements Listener{

	@EventHandler
    public void on(PlayerBedEnterEvent e){
    	Player p = e.getPlayer();
    	e.setCancelled(true);
    	p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§cHier darf man kein Bett benutzen!");
    		
    }
}
